package py.com.datasystems.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.datasystems.api.entity.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {
	Void save(Optional<Sala> salaToUpdate);
}
