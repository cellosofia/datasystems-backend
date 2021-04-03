package py.com.datasystems.api.service;

import java.util.List;
import java.util.Optional;

import py.com.datasystems.api.entity.Reserva;

public interface ReservaService {
	public List <Reserva> findAllReservas();
	
	public Optional<Reserva> findReservaById(Long id);

	public String saveReserva(Reserva reservaNew);
	
	public String deleteReserva(Long id);
	
	public String updateReserva(Reserva reservaUpdated);
	
	public boolean isScheduleAvailable(Reserva reserva);
}
