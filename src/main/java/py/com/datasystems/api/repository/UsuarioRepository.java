package py.com.datasystems.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.datasystems.api.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {	
	Void save(Optional<Usuario> usuarioToUpdate);
}