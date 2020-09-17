import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCExemplo1ConexaoMysql {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//Class é usada para fazer uma representação do objeto necessário até o java 5, após não é necessário, mas é necessário também em servlet container as vezes.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//DriverManager é a classe concreta que implementa a interface JDBC basta passar a string de conexão
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/fj21?useTimezonetrue&serverTimezone=UTC","root","admin");
		System.out.println("Conectado!");
		conexao.close();	
	}
}
