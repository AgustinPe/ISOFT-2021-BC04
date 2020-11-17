package es.uclm.esi.iso2.bc4.Yakitoro.dao;

import java.sql.ResultSet;
import java.util.logging.Logger;

public class pruebaDAO {

	private static Logger log = Logger.getLogger(pruebaDAO.class.getName());
	
    public static void main( String[] args ) {
		try {
			ConnectionDataBase conn = new ConnectionDataBase();
			String sql = "SELECT * FROM INFORMATION_SCHEMA.TABLES";
			ResultSet resultset = conn.getConn().createStatement().executeQuery(sql);
			String tablas = "";
			while(resultset.next()) {
				tablas += resultset.getString("TABLE_NAME")+" ";
			}
			
			log.info("tablas de la base de datos: "+tablas);
		}catch (Exception e) {
			log.info("Error, excepcion: \n");
			log.info(e.toString());
		}
	}
}
