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
import py.com.datasystems.api.controller.SalaController;
import py.com.datasystems.api.entity.Sala;
import py.com.datasystems.api.entity.Usuario;
import py.com.datasystems.api.service.SalaService;

@RestController
@RequestMapping("/salas")
public class SalaControllerImpl implements SalaController {
	@Autowired
	SalaService salaService;

	@Operation(summary = "Lista todas las salas")
	@ApiResponse(responseCode = "200", description = "Lista de salas consultada correctamente", 
    content = { @Content(mediaType = "application/json", 
    array = @ArraySchema(schema = @Schema(implementation = Sala.class))) })
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<Sala> getSalas() {
		// SalaService service = new SalaServiceImpl();
		return salaService.findAllSalas();
	}
	

	@Operation(summary = "Obtiene una sala por su ID")
	@ApiResponse(responseCode = "200", description = "Sala encontrada por el ID correctamente", 
    content = { @Content(mediaType = "application/json",
    schema = @Schema(implementation = Sala.class)) })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@Override
	public Optional<Sala> getSalaById(@PathVariable Long id) {
		return salaService.findSalaById(id);
	}


	@Operation(summary = "Crea una sala")
	@ApiResponse(responseCode = "200", description = "Modelo de la sala creado correctamente", 
    content = { @Content(mediaType = "application/json",
    schema = @Schema(implementation = Sala.class)) })
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	@Override
	public Sala addSala(@RequestBody Sala sala) {
		return salaService.saveSala(sala);
	}


	@Operation(summary = "Elimina una sala por su ID")
	@ApiResponse(responseCode = "200", description = "Mensaje de eliminación correctamente", 
    content = { @Content(mediaType = "application/json",
    schema = @Schema(implementation = String.class)) })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@Override
	public String deleteSala(@PathVariable Long id) {
		return salaService.deleteSala(id);
	}


	@Operation(summary = "Actualiza un modelo de sala existente")
	@ApiResponse(responseCode = "200", description = "Mensaje de actualización correctamente", 
    content = { @Content(mediaType = "application/json",
    schema = @Schema(implementation = String.class)) })
	@RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
	@Override
	public String updateSala(@RequestBody Sala salaUpdated) {
		return salaService.updateSala(salaUpdated);
	}
}
