package py.com.datasystems.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import py.com.datasystems.api.entity.Sala;

public interface SalaController {
	public List<Sala> getSalas();
	
	public Optional<Sala> getSalaById(Long id);
	
	public Sala addSala(Sala sala);
	
	public ResponseEntity<?> deleteSala(Long id);
	
	public String updateSala(Sala salaUpdated);
}
