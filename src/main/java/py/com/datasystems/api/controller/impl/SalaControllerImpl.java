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

import py.com.datasystems.api.controller.SalaController;
import py.com.datasystems.api.entity.Sala;
import py.com.datasystems.api.service.SalaService;

@RestController
@RequestMapping("/salas")
public class SalaControllerImpl implements SalaController {
	@Autowired
	SalaService salaService;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<Sala> getSalas() {
		// SalaService service = new SalaServiceImpl();
		return salaService.findAllSalas();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@Override
	public Optional<Sala> getSalaById(@PathVariable Long id) {
		return salaService.findSalaById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	@Override
	public Sala addSala(@RequestBody Sala sala) {
		return salaService.saveSala(sala);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@Override
	public ResponseEntity<?> deleteSala(@PathVariable Long id) {
		salaService.deleteSala(id);
		return ResponseEntity.ok(null);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
	@Override
	public String updateSala(@RequestBody Sala salaUpdated) {
		return salaService.updateSala(salaUpdated);
	}
}
