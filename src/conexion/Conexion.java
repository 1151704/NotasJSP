package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

	private static Connection cnn;
	private static final String DB = "web_usuario";
	private static final String USER = "root";
	private static final String PASS = "";

	private Conexion() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB, USER, PASS);
		} catch (SQLException | ClassNotFoundException ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	/**
	 * Obtener conexion de la base de datos
	 *
	 * @return conexion de base de datos
	 */
	public static Connection getCnn() {

		if (cnn == null) {
			new Conexion();
		}

		return cnn;
	}

	/**
	 * Obtener nombre de la base de datos
	 *
	 * @return Nombre de la base de datos
	 */
	public static String getDb() {
		return DB;
	}

	/**
	 * Cerrar conexion
	 */
	public static void close() {
		cnn = null;
	}

}
