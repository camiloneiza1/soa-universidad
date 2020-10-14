package co.edu.ucentral.common.evaluacion.model;

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

import co.edu.ucentral.common.grupo.model.Grupo;

@Entity
@Table(name = "evaluaciones")
public class Evaluacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private int tiempo;
	private int puntos;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="grupo_id")
	private Grupo grupo;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="evaluacion_id")
	private List<EvaluacionPregunta> ePreguntas;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@PrePersist
	private void prePersist() {
		this.createAt = new Date();
	}
	
	public Evaluacion() {
		this.ePreguntas= new ArrayList<>();
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getTiempo() {
		return tiempo;
	}


	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}


	public Grupo getGrupo() {
		return grupo;
	}


	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	

	public List<EvaluacionPregunta> getePreguntas() {
		return ePreguntas;
	}


	public void setePreguntas(List<EvaluacionPregunta> ePreguntas) {
		this.ePreguntas = ePreguntas;
	}

	public void addePregunta(EvaluacionPregunta epregunta) {
		this.ePreguntas.add(epregunta);
	}
	
	public void removeePregunta(EvaluacionPregunta epregunta) {
		this.ePreguntas.remove(epregunta);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
