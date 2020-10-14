package co.edu.ucentral.app.servicio.facultad.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.servicio.facultad.service.FacultadService;
import co.edu.ucentral.common.facultad.model.Facultad;
import co.edu.ucentral.servicio.common.controller.CommonController;

@RestController
public class FacultadController extends CommonController<Facultad, FacultadService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Facultad facultad, BindingResult result, @PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Facultad> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Facultad facultadBd = optional.get();
		facultadBd.setNombre(facultad.getNombre());
		facultadBd.setDescripcion(facultad.getDescripcion());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(facultadBd));
	}
}
