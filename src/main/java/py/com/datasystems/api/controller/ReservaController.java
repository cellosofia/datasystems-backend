package py.com.datasystems.api.controller;

import java.util.List;
import java.util.Optional;

import py.com.datasystems.api.entity.Reserva;

public interface ReservaController {
	public List<Reserva> getReservas();
	
	public Optional<Reserva> getReservaById(Long id);
	
	public String addReserva(Reserva reserva);
	
	public String deleteReserva(Long id);
	
	public String updateReserva(Reserva reservaUpdated);
}
