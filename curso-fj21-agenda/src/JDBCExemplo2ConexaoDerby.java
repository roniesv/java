import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExemplo2ConexaoDerby {
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/curso-fj21-agenda", "admin", "admin");
	System.out.println("Seja bem vindo ao Derby, conectado com sucesso.");
	conn.close();
	}

}
