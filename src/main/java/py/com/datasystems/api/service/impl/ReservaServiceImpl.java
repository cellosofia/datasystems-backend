package py.com.datasystems.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.datasystems.api.entity.Reserva;
import py.com.datasystems.api.repository.ReservaRepository;
import py.com.datasystems.api.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {
	@Autowired
	ReservaRepository reservaRepository;

	@Override
	public List<Reserva> findAllReservas() {
		return reservaRepository.findAll();
	}

	@Override
	public Optional<Reserva> findReservaById(Long id) {
		return reservaRepository.findById(id);
	}

	@Override
	public String saveReserva(Reserva reservaNew) {
		if (isScheduleAvailable(reservaNew)) {
			reservaRepository.save(reservaNew);
			return "Reserva creada correctamente";
		}
		
		return "El horario y día ya está ocupado para la reserva";
	}

	@Override
	public String deleteReserva(Long id) {
		if (reservaRepository.findById(id).isPresent()) {
			reservaRepository.deleteById(id);
			return "Reserva eliminada correctamente.";
		}
		return "Error! La reserva no existe";
	}

	@Override
	public String updateReserva(Reserva reservaUpdated) {
		if (reservaRepository.findById(reservaUpdated.getId()).isPresent() 
				&& isScheduleAvailable(reservaUpdated)) {
			Reserva reservaToUpdate = new Reserva();
			reservaToUpdate.setId(reservaUpdated.getId());
			reservaToUpdate.setSala(reservaUpdated.getSala());
			reservaToUpdate.setUsuario(reservaUpdated.getUsuario());
			reservaToUpdate.setFecha(reservaUpdated.getFecha());
			reservaToUpdate.setHoraDesde(reservaUpdated.getHoraDesde());
			reservaToUpdate.setHoraHasta(reservaUpdated.getHoraHasta());
			reservaRepository.save(reservaToUpdate);
			return "Reserva actualizada correctamente";
		}
		
		return "El horario y día ya está ocupado para la reserva";
	}

	@Override
	public boolean isScheduleAvailable(Reserva reserva) {
		return reservaRepository.verifySchedule(reserva.getFecha(),
				reserva.getHoraDesde(),
				reserva.getHoraHasta()) == 0;
	}
}
