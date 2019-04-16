package prog.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import prog.web.model.Notificacoes;
import prog.web.util.DbUtil;

public class NotificacoesDao {

	private Connection connection;

	public NotificacoesDao() {
		connection = DbUtil.getConnection();
	}

	public void add(Notificacoes notificacao) {
		
	}
	
	public void delete(int userId) {
		
	}
	
	public void update(Notificacoes notificacao) {
		
	}

	public List<Notificacoes> getAll() {
		List<Notificacoes> notificacaos = new ArrayList<Notificacoes>();
		
                return notificacaos;
	}
	
	public Notificacoes getById(Integer id) {
		Notificacoes notificacao = new Notificacoes();
		
		return notificacao;
	}
}
