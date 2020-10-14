package co.edu.ucentral.common.grupo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.edu.ucentral.common.curso.model.Curso;
import co.edu.ucentral.common.profesor.model.Profesor;

@Entity
@Table(name = "grupos")
public class Grupo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codigo;
	@Column(name = "cupo_max")
	private int cupoMax;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="profesor_id")
	private Profesor profesor;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="curso_id")
	private Curso curso;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="grupo_id")
	private List<EstudianteGrupo> estudiantes;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	public Grupo() {
		this.estudiantes= new ArrayList<>();
	}
	
	@PrePersist
	private void prePersist() {
		this.createAt = new Date();
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public int getCupoMax() {
		return cupoMax;
	}


	public void setCupoMax(int cupoMax) {
		this.cupoMax = cupoMax;
	}


	public Profesor getProfesor() {
		return profesor;
	}


	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	
	public List<EstudianteGrupo> getEstudiantes() {
		return estudiantes;
	}


	public void setEstudiantes(List<EstudianteGrupo> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public void addEstudiante(EstudianteGrupo estudianteGrupo) {
		this.estudiantes.add(estudianteGrupo);
	}
	
	public void removeEstudiante(EstudianteGrupo estudianteGrupo) {
		this.estudiantes.remove(estudianteGrupo);
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
