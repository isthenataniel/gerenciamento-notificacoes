package prog.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import prog.web.dao.NotificacoesDao;

import prog.web.model.Notificacoes;

public class NotificacoesController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/notificacao.jsp";
    private static String LIST_USER = "/notificacaoLista.jsp";
    private NotificacoesDao dao;

    public NotificacoesController() {
        super();
        dao = new NotificacoesDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            dao.delete(id);
            forward = LIST_USER;
            request.setAttribute("notificacao", dao.getAll());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Notificacoes notificacao = dao.getById(id);
            request.setAttribute("notificacao", notificacao);
        } else if (action.equalsIgnoreCase("list")){
            forward = LIST_USER;
            request.setAttribute("notificacao", dao.getAll());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Notificacoes notificacao = new Notificacoes();
//        notificacao.setNome(request.getParameter("nome"));
//        notificacao.setDescricao(request.getParameter("descricao"));
//        String id = request.getParameter("id");
//        if(id == null || id.isEmpty()) {
//            dao.add(notificacao);
//        }
//        else {
//            notificacao.setId(Integer.parseInt(id));
//            dao.update(notificacao);
//        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("notificacao", dao.getAll());
        view.forward(request, response);
    }
}