package py.com.datasystems.api.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import py.com.datasystems.api.controller.ReservaController;
import py.com.datasystems.api.entity.Reserva;
import py.com.datasystems.api.entity.Usuario;
import py.com.datasystems.api.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaControllerImpl implements ReservaController {
	@Autowired
	ReservaService reservaService;


	@Operation(summary = "Lista todas las reservas")
	@ApiResponse(responseCode = "200", description = "Lista de reservas consultada correctamente", 
    content = { @Content(mediaType = "application/json", 
    array = @ArraySchema(schema = @Schema(implementation = Reserva.class))) })
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<Reserva> getReservas() {
		return reservaService.findAllReservas();
	}


	@Operation(summary = "Obtiene una reserva por su ID")
	@ApiResponse(responseCode = "200", description = "Reserva encontrada por el ID correctamente", 
    content = { @Content(mediaType = "application/json",
    schema = @Schema(implementation = Reserva.class)) })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@Override
	public Optional<Reserva> getReservaById(@PathVariable Long id) {
		return reservaService.findReservaById(id);
	}


	@Operation(summary = "Crea una reserva")
	@ApiResponse(responseCode = "200", description = "Modelo de la reserva creado correctamente", 
    content = { @Content(mediaType = "application/json",
    schema = @Schema(implementation = Reserva.class)) })
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	@Override
	public String addReserva(@RequestBody Reserva reserva) {
		return reservaService.saveReserva(reserva);
	}


	@Operation(summary = "Elimina una reserva por su ID")
	@ApiResponse(responseCode = "200", description = "Mensaje de eliminación correctamente", 
    content = { @Content(mediaType = "application/json",
    schema = @Schema(implementation = String.class)) })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@Override
	public String deleteReserva(@PathVariable Long id) {
		return reservaService.deleteReserva(id);
	}


	@Operation(summary = "Actualiza un modelo de reserva existente")
	@ApiResponse(responseCode = "200", description = "Mensaje de actualización correctamente", 
    content = { @Content(mediaType = "application/json",
    schema = @Schema(implementation = String.class)) })
	@RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
	@Override
	public String updateReserva(@RequestBody Reserva reservaUpdated) {
		return reservaService.updateReserva(reservaUpdated);
	}
}