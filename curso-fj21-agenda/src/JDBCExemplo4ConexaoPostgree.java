import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExemplo4ConexaoPostgree {
	
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fj21", "postgres", "admin");
			System.out.println("Conectado com sucesso, Seja bem vindo ao Postgre");
			Statement stmt = conn.createStatement();
			stmt.executeQuery("select * from contatos");
			ResultSet rs = stmt.getResultSet();
			while(rs.next()) {
				System.out.println(rs.getString("nome"));
				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("datanascimento"));
				
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		
		
	}

}
