package pe.gob.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Denuncias")
public class Denuncias implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDenuncias;
	
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="Lugar", nullable=false, length=30)
	private String Lugar;
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que NO Existe")
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_de_denuncia")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaDenuncia;
	
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="Descripcion", nullable=false, length=120)
	private String Descripcion;
	
	@ManyToOne
	@JoinColumn(name="idDelitos", nullable = false)
	private Delitos delitos;
	
	@ManyToOne
	@JoinColumn(name="idComisaria", nullable = false)	
	private Comisaria comisaria;

	@ManyToOne
	@JoinColumn(name="idUsuarios", nullable = false)	
	private Usuarios idUsuarios;

	public Denuncias() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Denuncias(int idDenuncias,
			String lugar,
			Date fechaDenuncia,
			String descripcion, Delitos delitos, 
			Comisaria comisaria,
			Usuarios idUsuarios) {
		super();
		this.idDenuncias = idDenuncias;
		Lugar = lugar;
		this.fechaDenuncia = fechaDenuncia;
		Descripcion = descripcion;
		this.delitos = delitos;
		this.comisaria = comisaria;
		this.idUsuarios = idUsuarios;
	}

	public int getIdDenuncias() {
		return idDenuncias;
	}

	public void setIdDenuncias(int idDenuncias) {
		this.idDenuncias = idDenuncias;
	}

	public String getLugar() {
		return Lugar;
	}

	public void setLugar(String lugar) {
		Lugar = lugar;
	}

	public Date getFechaDenuncia() {
		return fechaDenuncia;
	}

	public void setFechaDenuncia(Date fechaDenuncia) {
		this.fechaDenuncia = fechaDenuncia;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Delitos getDelitos() {
		return delitos;
	}

	public void setDelitos(Delitos delitos) {
		this.delitos = delitos;
	}

	public Comisaria getComisaria() {
		return comisaria;
	}

	public void setComisaria(Comisaria comisaria) {
		this.comisaria = comisaria;
	}

	public Usuarios getIdUsuarios() {
		return idUsuarios;
	}

	public void setIdUsuarios(Usuarios idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	
	
}
