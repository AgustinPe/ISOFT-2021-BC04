package es.uclm.esi.iso2.bc4.Yakitoro.dao;

import java.sql.PreparedStatement;

import es.uclm.esi.iso2.bc4.Yakitoro.modelo.Reserva;

public class ReservaDAO {

	public int insertReservas(Reserva reserva) {
		try (ConnectionDataBase bd = Broker.get().getBd()) {
			String sql = "insert into reserva (fecha, nombrePersona, numComensales, mesas) "
					+ "values (?, ?, ?, ?)";
			try (PreparedStatement ps = bd.prepareStatement(sql)) {
				ps.setString(1, reserva.getFecha());
				ps.setString(2, reserva.getPersona());
				ps.setInt(3, reserva.getNumComensales());
				ps.setString(4, reserva.getMesas());
				return ps.executeUpdate();
			}
			
		} catch (Exception e) {
			return 0;
		}
	}
}