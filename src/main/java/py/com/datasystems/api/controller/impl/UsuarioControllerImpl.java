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
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import py.com.datasystems.api.controller.UsuarioController;
import py.com.datasystems.api.entity.Usuario;
import py.com.datasystems.api.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControllerImpl implements UsuarioController {
	@Autowired
	UsuarioService usuarioService;

	@Operation(summary = "Lista todos los usuarios")
	@ApiResponse(responseCode = "200", description = "Lista de usuarios consultada correctamente", 
    content = { @Content(mediaType = "application/json", 
    array = @ArraySchema(schema = @Schema(implementation = Usuario.class))) })
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")	
	@Override
	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = usuarioService.findAllUsuarios();
		return usuarios;
	}

	@Operation(summary = "Obtiene un usuario por su ID")
	@ApiResponse(responseCode = "200", description = "Usuario encontrado por el ID correctamente", 
    content = { @Content(mediaType = "application/json",
    schema = @Schema(implementation = Usuario.class)) })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")	
	@Override
	public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
		return usuarioService.findUsuarioById(id);
	}

	@Operation(summary = "Crea un usuario")
	@ApiResponse(responseCode = "200", description = "Modelo del usuario creado correctamente", 
    content = { @Content(mediaType = "application/json",
    schema = @Schema(implementation = Usuario.class)) })
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")	
	@Override
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.saveUsuario(usuario);
	}

	@Operation(summary = "Elimina un usuario por su ID")
	@ApiResponse(responseCode = "200", description = "Mensaje de eliminación correctamente", 
    content = { @Content(mediaType = "application/json",
    schema = @Schema(implementation = String.class)) })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")	
	@Override
	public String deleteUsuario(@PathVariable Long id) {
		return usuarioService.deleteUsuario(id);
	}

	@Operation(summary = "Actualiza un modelo de usuario existente")
	@ApiResponse(responseCode = "200", description = "Mensaje de actualización correctamente", 
    content = { @Content(mediaType = "application/json",
    schema = @Schema(implementation = String.class)) })
	@RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")	
	@Override
	public String updateUsuario(@RequestBody Usuario usuarioUpdated) {
		return usuarioService.updateUsuario(usuarioUpdated);
	}
}
