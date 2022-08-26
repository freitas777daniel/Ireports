package conexao;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {

	
	
	//Essa é a string de conexão com o banco de daddos.
	public static Connection getConnection() {
		
		String url;
		String usuario;
		String senha;
		Connection con = null;
		
		url     = "jdbc:postgresql://172.25.136.119:5432/dbveiculos_dev";
		usuario = "danielsouza";
		senha   = "4633897dcf65664e2077226ac996ec32b2778cac";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url,usuario,senha);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	//---------------------------------------------------------------
	
}
