package py.com.datasystems.api.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.com.datasystems.api.controller.ReservaController;
import py.com.datasystems.api.entity.Reserva;
import py.com.datasystems.api.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaControllerImpl implements ReservaController {
	@Autowired
	ReservaService reservaService;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<Reserva> getReservas() {
		return reservaService.findAllReservas();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@Override
	public Optional<Reserva> getReservaById(@PathVariable Long id) {
		return reservaService.findReservaById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	@Override
	public String addReserva(@RequestBody Reserva reserva) {
		return reservaService.saveReserva(reserva);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@Override
	public ResponseEntity<?> deleteReserva(@PathVariable Long id) {
		reservaService.deleteReserva(id);
		return ResponseEntity.ok(null);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
	@Override
	public String updateReserva(@RequestBody Reserva reservaUpdated) {
		return reservaService.updateReserva(reservaUpdated);
	}
}