package py.com.datasystems.api.controller;

import java.util.List;
import java.util.Optional;

import py.com.datasystems.api.entity.Sala;

public interface SalaController {
	public List<Sala> getSalas();
	
	public Optional<Sala> getSalaById(Long id);
	
	public Sala addSala(Sala sala);
	
	public String deleteSala(Long id);
	
	public String updateSala(Sala salaUpdated);
}
