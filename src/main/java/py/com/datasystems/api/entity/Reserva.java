package py.com.datasystems.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "sala_id")
	Sala sala;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	Usuario usuario;
	
	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="America/Asuncion")
	Date fecha;
	
	@Column(name ="hora_desde")
	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss", timezone="America/Asuncion")
	Date horaDesde;
	
	@Column(name = "hora_hasta")
	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss", timezone="America/Asuncion")
	Date horaHasta;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(Date horaDesde) {
		this.horaDesde = horaDesde;
	}

	public Date getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(Date horaHasta) {
		this.horaHasta = horaHasta;
	}
}