package py.com.datasystems.api.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.com.datasystems.api.controller.UsuarioController;
import py.com.datasystems.api.entity.Usuario;
import py.com.datasystems.api.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControllerImpl implements UsuarioController {
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")	
	@Override
	public List<Usuario> getUsuarios() {
		return usuarioService.findAllUsuarios();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")	
	@Override
	public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
		return usuarioService.findUsuarioById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")	
	@Override
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.saveUsuario(usuario);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")	
	@Override
	public String deleteUsuario(@PathVariable Long id) {
		return usuarioService.deleteUsuario(id);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")	
	@Override
	public String updateUsuario(@RequestBody Usuario usuarioUpdated) {
		return usuarioService.updateUsuario(usuarioUpdated);
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")	
	@Override
	public String test() {
		return "Test done";
	}
}
