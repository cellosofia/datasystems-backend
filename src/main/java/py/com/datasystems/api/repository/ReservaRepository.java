package py.com.datasystems.api.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import py.com.datasystems.api.entity.Reserva;


public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	Void save(Optional<Reserva> reservaToUpdate);
	
	@Query(value = "select count(id) from reservas r where r.fecha = :fecha and r.hora_desde >= :horaDesde and r.hora_hasta <= :horaHasta", 
			nativeQuery = true)
	Long verifySchedule(@Param("fecha") Date fecha,
			@Param("horaDesde") Date horaDesde,
			@Param("horaHasta") Date horaHasta);
}
