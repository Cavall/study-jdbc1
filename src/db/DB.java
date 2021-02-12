package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	// vamos criar alguns metodos estaticos para conecatar e desconectar com o banco
	// de dados

	// segundo passo criar metodo para conectar com o banco de dados, antes temos
	// que declarar
	// um objeto para conexao Conect

	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			}

			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;

	}
	
	//terceiro passo criar metodo para fechar a conexao com o bd
	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
				
			}
			catch (SQLException e ) {
				throw new DbException(e.getMessage());
			}
		}
		
	}

	// primeiro criamos o objeto properties para ler e armazenar os dados
	// do arquivo db.properties...metodo auxiliar

	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;

		} catch (IOException e) {
			throw new DbException(e.getMessage());

		}
	}
}
