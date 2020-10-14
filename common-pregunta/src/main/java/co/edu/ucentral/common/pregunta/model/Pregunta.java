package co.edu.ucentral.common.pregunta.model;

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

@Entity
@Table(name = "preguntas")
public class Pregunta implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String enunciado;
	private String foto;
	@Column(name = "tipo_respuesta")
	private int tipoRespuesta;
	private int puntos;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="curso_id")
	private Curso curso;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="pregunta_id")
	private List<OpcionesPregunta> opciones;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	public Pregunta() {
		this.opciones= new ArrayList<>();
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


	public String getEnunciado() {
		return enunciado;
	}


	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public int getTipoRespuesta() {
		return tipoRespuesta;
	}


	public void setTipoRespuesta(int tipoRespuesta) {
		this.tipoRespuesta = tipoRespuesta;
	}


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
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
	

	public List<OpcionesPregunta> getOpciones() {
		return opciones;
	}


	public void setOpciones(List<OpcionesPregunta> opciones) {
		this.opciones = opciones;
	}

	public void addOpcion(OpcionesPregunta opcion) {
		this.opciones.add(opcion);
	}
	
	public void removeOpcion(OpcionesPregunta opcion) {
		this.opciones.remove(opcion);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
