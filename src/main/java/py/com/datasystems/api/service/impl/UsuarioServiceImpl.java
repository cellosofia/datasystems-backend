package py.com.datasystems.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.datasystems.api.entity.Usuario;
import py.com.datasystems.api.repository.UsuarioRepository;
import py.com.datasystems.api.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findUsuarioById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario;
	}

	@Override
	public Usuario saveUsuario(Usuario usuarioNew) {
		if (usuarioNew != null) {
			return usuarioRepository.save(usuarioNew);
		}
		return new Usuario();
	}

	@Override
	public String deleteUsuario(Long id) {
		if (usuarioRepository.findById(id).isPresent()) {
			usuarioRepository.deleteById(id);
			return "Usuario eliminado correctamente.";
		}
		return "Error! El usuario no existe";
	}

	@Override
	public String updateUsuario(Usuario usuarioUpdated) {
		if (usuarioRepository.findById(usuarioUpdated.getId()).isPresent()) {
			Usuario usuarioToUpdate = new Usuario();
			usuarioToUpdate.setId(usuarioUpdated.getId());
			usuarioToUpdate.setNombre(usuarioUpdated.getNombre());
			usuarioToUpdate.setEmail(usuarioUpdated.getEmail());
			usuarioToUpdate.setTelefono(usuarioUpdated.getTelefono());
			usuarioRepository.save(usuarioToUpdate);
			return "Usuario modificado";
		}
		return "Error al modificar el Customer";
	}
}
