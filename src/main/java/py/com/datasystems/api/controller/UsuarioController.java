package py.com.datasystems.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import py.com.datasystems.api.entity.Usuario;

public interface UsuarioController {
	public List<Usuario> getUsuarios();
	
	public Optional<Usuario> getUsuarioById(Long id);
	
	public Usuario addUsuario(Usuario usuario);
	
	public ResponseEntity<?> deleteUsuario(Long id);
	
	public String updateUsuario(Usuario usuarioUpdated);
}
