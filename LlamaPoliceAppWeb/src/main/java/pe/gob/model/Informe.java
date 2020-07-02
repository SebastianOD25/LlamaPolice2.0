package pe.gob.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Informe")
public class Informe implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInforme;
	
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="Descripcion", nullable=false, length=30)
	private String Descripcion;
	
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="Respuesta", nullable=false, length=10)
	private String Respuesta;
	
	@ManyToOne
	@JoinColumn(name="idUsuario", nullable = false)	
	private Usuarios usuario;
	
	@ManyToOne
	@JoinColumn(name="idReporte", nullable = false)	
	private Reporte reporte;

	public Informe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Informe(int idInforme, @NotBlank(message = "No puede estar en blanco") String descripcion,
			@NotBlank(message = "No puede estar en blanco") String respuesta, Usuarios usuario, Reporte reporte) {
		super();
		this.idInforme = idInforme;
		Descripcion = descripcion;
		Respuesta = respuesta;
		this.usuario = usuario;
		this.reporte = reporte;
	}

	public int getIdInforme() {
		return idInforme;
	}

	public void setIdInforme(int idInforme) {
		this.idInforme = idInforme;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getRespuesta() {
		return Respuesta;
	}

	public void setRespuesta(String respuesta) {
		Respuesta = respuesta;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Reporte getReporte() {
		return reporte;
	}

	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}
	
}
