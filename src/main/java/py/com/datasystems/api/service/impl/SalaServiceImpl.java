package py.com.datasystems.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.datasystems.api.entity.Sala;
import py.com.datasystems.api.repository.SalaRepository;
import py.com.datasystems.api.service.SalaService;

@Service
public class SalaServiceImpl implements SalaService {
	@Autowired
	SalaRepository salaRepository;

	@Override
	public List<Sala> findAllSalas() {
		return salaRepository.findAll(); // select * from salas
	}

	@Override
	public Optional<Sala> findSalaById(Long id) {
		return salaRepository.findById(id);
	}

	@Override
	public Sala saveSala(Sala salaNew) {
		return salaRepository.save(salaNew);
	}

	@Override
	public String deleteSala(Long id) {
		if (salaRepository.findById(id).isPresent()) {
			salaRepository.deleteById(id);
			return "Sala eliminada correctamente.";
		}
		return "Error! La sala no existe";
	}

	@Override
	public String updateSala(Sala salaUpdated) {
		if (salaRepository.findById(salaUpdated.getId()).isPresent()) {
			Sala salaToUpdate = new Sala();
			salaToUpdate.setId(salaUpdated.getId());
			salaToUpdate.setDescripcion(salaUpdated.getDescripcion());
			salaToUpdate.setNumero(salaUpdated.getNumero());
			salaRepository.save(salaToUpdate);
			return "Sala modificada";
		}
		return "Error al modificar la Sala";
	}
	
}
