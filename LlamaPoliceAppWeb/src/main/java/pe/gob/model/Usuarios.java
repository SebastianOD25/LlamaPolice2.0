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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="Usuarios")
public class Usuarios implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@Size(min=8,max=11)
	@NotEmpty(message = "No puede dejar el nombre vacio")
	@NotBlank(message = "No deje el espacio en blanco")
	@Column(name=" usercode",length=11, unique = true)
	private String usercode;
	
	@NotEmpty(message = "No puede dejar el nombre vacio")
	@Column(name= "password",length=90, unique = true)
	private String password;

	@Column(name = "dni", length = 8,nullable = false)
	private int dni;
	
	@NotEmpty(message = "No puede dejar el nombre vacio")
	@Column(name = "nombre", length = 30,nullable = false)
	private String nombre;
	
	@Column(name = "telefono", length = 9,nullable = false)
	private int telefono;
	
	
	@NotEmpty(message = "No puede dejar este espacio vacio")
	@Column(name = "correo", length = 30,nullable = false)
	private String correo;
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que NO Existe")
	@Temporal(TemporalType.DATE)
	@Column(name="fechaNacimiento")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaNacimiento;
	
	@ManyToOne
	@JoinColumn(name = "idRol", nullable = false)
	private Roles idRol;

	public Usuarios() {
		super();
	}

	public Usuarios(int idUsuario,
			String usercode,
			String password, int dni,
			String nombre, int telefono,
			String correo,
			Date fechaNacimiento, Roles idRol) {
		super();
		this.idUsuario = idUsuario;
		this.usercode = usercode;
		this.password = password;
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.idRol = idRol;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Roles getIdRol() {
		return idRol;
	}

	public void setIdRol(Roles idRol) {
		this.idRol = idRol;
	}
	
}
