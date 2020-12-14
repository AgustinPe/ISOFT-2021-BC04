package es.uclm.esi.iso2.bc4.Yakitoro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionDataBase implements AutoCloseable{

	private Connection connection;
	private final Logger log = Logger.getLogger(Connection.class.getName());
	
	public ConnectionDataBase() {
		try {
			String url = "jdbc:mysql://172.20.48.70:3306/BC04dbservice?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            this.connection = DriverManager.getConnection(url, "BC04", "n2kduXMjGt@");
		    log.info("Conexion realizada correctamente a la BaseDatos: "+this.connection.getCatalog());
		}catch (Exception e){
			log.info("La conexión con la BBDD ha fallado");
		}
	}
	
	public PreparedStatement prepareStatement(String sql) {
        try {
            return this.connection.prepareStatement(sql);
        } catch (SQLException e) {
        	log.info("La conexión con la BBDD ha fallado");
        }
        return null;
    }
	
	@Override
	public void close() throws Exception {
		
	}
}
