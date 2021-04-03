package py.com.datasystems.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.datasystems.api.entity.Reserva;


public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	Void save(Optional<Reserva> reservaToUpdate);

}
