package py.com.datasystems.api.service;

import java.util.List;
import java.util.Optional;

import py.com.datasystems.api.entity.Usuario;

public interface UsuarioService{
	
	public List <Usuario> findAllUsuarios();
	
	public Optional <Usuario> findUsuarioById(Long id);
	
	public Usuario saveUsuario(Usuario usuarioNew);
	
	public String deleteUsuario(Long id);
	
	public String updateUsuario(Usuario usuarioUpdated);
}