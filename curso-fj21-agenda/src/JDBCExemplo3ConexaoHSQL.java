import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExemplo3ConexaoHSQL {

	public static void main(String[] args) throws SQLException {
		//subir o banco e add o driver.
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/test", "sa", "");
			System.out.println("Bem vindo ao HSQLDB, conexão com sucesso");
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
