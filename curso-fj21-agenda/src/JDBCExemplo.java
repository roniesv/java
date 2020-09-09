import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCExemplo {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//Class é usada para fazer uma representação do objeto necessário até o java 5, após não é necessário, mas é necessário também em servlet container as vezes.
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/test?useTimezonetrue&serverTimezone=UTC","ronie","admin3393");
		System.out.println("Conectado!");
		conexao.close();	
	}
}
