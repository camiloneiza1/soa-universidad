package co.edu.ucentral.app.servicio.grupo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.servicio.grupo.service.GrupoService;
import co.edu.ucentral.common.grupo.model.EstudianteGrupo;
import co.edu.ucentral.common.grupo.model.Grupo;
import co.edu.ucentral.servicio.common.controller.CommonController;

@RestController
public class GrupoController extends CommonController<Grupo, GrupoService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Grupo grupo, BindingResult result, @PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Grupo> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Grupo grupoBd = optional.get();
		grupoBd.setCodigo(grupo.getCodigo());
		grupoBd.setCupoMax(grupo.getCupoMax());
		grupoBd.setProfesor(grupo.getProfesor());
		grupoBd.setCurso(grupo.getCurso());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(grupoBd));
	}
	
	@PutMapping("/{id}/addEstudiante-Grupo")
	public ResponseEntity<?> asignarItemFactura(@RequestBody EstudianteGrupo estudianteGrupo, @PathVariable Long id){
		Optional<Grupo> optional = this.service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Grupo grupoBd = optional.get();
		grupoBd.addEstudiante(estudianteGrupo);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(grupoBd));
	}
	
	@PutMapping("/{id}/removeEstudiante-Grupo")
	public ResponseEntity<?> eliminarItemFactura(@RequestBody EstudianteGrupo estudianteGrupo, @PathVariable Long id){
		Optional<Grupo> optional = this.service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Grupo grupoBd = optional.get();
		grupoBd.removeEstudiante(estudianteGrupo);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(grupoBd));
	}
}
