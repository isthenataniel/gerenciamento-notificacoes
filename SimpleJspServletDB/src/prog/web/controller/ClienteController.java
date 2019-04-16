package prog.web.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import prog.web.dao.ClienteDao;

import prog.web.model.Cliente;
import prog.web.util.DbUtil;

public class ClienteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/clientes.jsp";
    private static String LIST = "/clienteLista.jsp";
    private ClienteDao dao;

    public ClienteController() {
        super();
        dao = new ClienteDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            dao.delete(id);
            forward = LIST;
            request.setAttribute("clientes", dao.getAll());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Cliente consulta = dao.getById(id);
            request.setAttribute("cliente", consulta);
        } else if (action.equalsIgnoreCase("list")){
            forward = LIST;
            request.setAttribute("clientes", dao.getAll());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente cliente = new Cliente();
        cliente.setClienteId(Integer.parseInt(request.getParameter("clienteId")));//request.getParameter("idpaciente"));
        cliente.setNome(request.getParameter("nome"));
        cliente.setNome(request.getParameter("email"));
        try {
            cliente.setInicio(DbUtil.stringToDate(request.getParameter("inicio")));
            cliente.setFim(DbUtil.stringToDate(request.getParameter("fim")));
            cliente.setHash(DbUtil.geraHash(cliente.getNome() + cliente.getEmail()));
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String id = request.getParameter("id");
        if(id == null || id.isEmpty()) {
            dao.add(cliente);
        }
        else {
            cliente.setClienteId(Integer.parseInt(id));
            dao.update(cliente);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST);
        request.setAttribute("clientes", dao.getAll());
        view.forward(request, response);
    }
}