package py.com.datasystems.api.service;

import java.util.List;
import java.util.Optional;

import py.com.datasystems.api.entity.Sala;

public interface SalaService {
	public List <Sala> findAllSalas();
	
	public Optional<Sala> findSalaById(Long id);

	public Sala saveSala(Sala salaNew);
	
	public String deleteSala(Long id);
	
	public String updateSala(Sala salaUpdated);
}
