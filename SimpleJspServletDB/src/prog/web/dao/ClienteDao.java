package prog.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import prog.web.model.Cliente;
import prog.web.util.DbUtil;

public class ClienteDao {

	private Connection connection;

	public ClienteDao() {
		connection = DbUtil.getConnection();
	}

	public void add(Cliente cliente) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO public.cliente(clienteid, nome, email, inicio, fim, hash)\n" +
                                                        "       VALUES (?, ?, ?, ?, ?, ?);");
			// Parameters start with 1
			preparedStatement.setInt(1, cliente.getClienteId());
                        preparedStatement.setString(2, cliente.getNome());
                        preparedStatement.setString(3, cliente.getEmail());
                        preparedStatement.setDate(4, DbUtil.dateUtilToDateSql(cliente.getInicio()));
                        preparedStatement.setDate(5, DbUtil.dateUtilToDateSql(cliente.getFim()));
                        preparedStatement.setString(6, cliente.getHash());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from public.cliente where clienteId=?");
			// Parameters start with 1
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Cliente cliente) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("  UPDATE public.cliente\n" +
                                                            "   SET nome=?, email=?, inicio=?, fim=?, hash=?\n" +
                                                            " WHERE clienteid=?;");
			// Parameters start with 1
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setDate(3, DbUtil.dateUtilToDateSql(cliente.getInicio()));
			preparedStatement.setDate(4, DbUtil.dateUtilToDateSql(cliente.getFim()));
			preparedStatement.setString(5, cliente.getHash());
			preparedStatement.setInt(6, cliente.getClienteId());
                        preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> getAll() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("  SELECT clienteid, nome, email, inicio, fim, hash\n" +
                                                                "  FROM public.cliente;");
			while (rs.next()) {
                            Cliente cliente = cliente = prepare(rs);
                            clientes.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
                return clientes;
	}
	
	public Cliente getById(Integer id) {
		Cliente cliente = new Cliente();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT clienteid, nome, email, inicio, fim, hash\n" +
                                                                "  FROM public.cliente"
                                                             + "  WHERE clienteid = ?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
                            cliente = prepare(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}
        
        protected Cliente prepare(ResultSet rs) throws SQLException {
            Cliente cliente = new Cliente();
            cliente.setClienteId(rs.getInt("clienteid"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setInicio(rs.getDate("inicio"));
            cliente.setFim(rs.getDate("fim"));
            cliente.setHash(rs.getString("hash"));
            return cliente;            
        }
}
