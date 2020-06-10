package pe.gob.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Persona")
public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersona;
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="nombrePersona", nullable=false, length=30)
	private String nomPersona;
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="dniPersona", nullable=false, length=8)
	private int dni;
	
	@Column(name="telefPersona", nullable=false, length=9)
	private int telef;
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que NO Existe")
	@Temporal(TemporalType.DATE)
	@Column(name="fechaNacimiento")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date cumpleP;
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="correoP", nullable=false, length=60)
	private String correoP;

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona(int idPersona,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String nomPersona,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") int dni,
			int telef, @NotNull @Past(message = "No puedes seleccionar un dia que NO Existe") Date cumpleP,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String correoP) {
		super();
		this.idPersona = idPersona;
		this.nomPersona = nomPersona;
		this.dni = dni;
		this.telef = telef;
		this.cumpleP = cumpleP;
		this.correoP = correoP;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNomPersona() {
		return nomPersona;
	}

	public void setNomPersona(String nomPersona) {
		this.nomPersona = nomPersona;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getTelef() {
		return telef;
	}

	public void setTelef(int telef) {
		this.telef = telef;
	}

	public Date getCumpleP() {
		return cumpleP;
	}

	public void setCumpleP(Date cumpleP) {
		this.cumpleP = cumpleP;
	}

	public String getCorreoP() {
		return correoP;
	}

	public void setCorreoP(String correoP) {
		this.correoP = correoP;
	}
	
}
