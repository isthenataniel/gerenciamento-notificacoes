package prog.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import prog.web.dao.ConexaoDao;

import prog.web.model.Conexao;

public class ConexaoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/conexao.jsp";
    private static String LIST = "/conexaoLista.jsp";
    private ConexaoDao dao;

    public ConexaoController() {
        super();
        dao = new ConexaoDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            dao.delete(id);
            forward = LIST;
            request.setAttribute("conexao", dao.getAll());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Conexao conexao = dao.getById(id);
            request.setAttribute("conexao", conexao);
        } else if (action.equalsIgnoreCase("list")){
            forward = LIST;
            request.setAttribute("conexao", dao.getAll());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Conexao conexao = new Conexao();
//        conexao.setNome(request.getParameter("nome"));
//        conexao.setCodigo(request.getParameter("codigo"));
//        String id = request.getParameter("id");
//        if(id == null || id.isEmpty()) {
//            dao.add(conexao);
//        }
//        else {
//            conexao.setId(Integer.parseInt(id));
//            dao.update(conexao);
//        }
        RequestDispatcher view = request.getRequestDispatcher(LIST);
        request.setAttribute("conexao", dao.getAll());
        view.forward(request, response);
    }
}