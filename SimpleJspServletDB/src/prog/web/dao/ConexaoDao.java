package prog.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import prog.web.model.Conexao;
import prog.web.util.DbUtil;

public class ConexaoDao {

	private Connection connection;

	public ConexaoDao() {
		connection = DbUtil.getConnection();
	}

	public void add(Conexao exame) {
		
	}
	
	public void delete(int userId) {
		
	}
	
	public void update(Conexao exame) {
		
	}

	public List<Conexao> getAll() {
		List<Conexao> notificacoes = new ArrayList<Conexao>();
		
                return notificacoes;
	}
	
	public Conexao getById(Integer id) {
		Conexao notificacao = new Conexao();
		

		return notificacao;
	}
}
