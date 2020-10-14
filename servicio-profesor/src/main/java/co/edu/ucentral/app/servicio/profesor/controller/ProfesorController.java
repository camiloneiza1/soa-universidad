package co.edu.ucentral.app.servicio.profesor.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.servicio.profesor.service.ProfesorService;
import co.edu.ucentral.common.profesor.model.Profesor;
import co.edu.ucentral.servicio.common.controller.CommonController;

@RestController
public class ProfesorController extends CommonController<Profesor, ProfesorService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Profesor profesor, BindingResult result, @PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Profesor> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Profesor profesordBd = optional.get();
		profesordBd.setNombres(profesor.getNombres());
		profesordBd.setApellidos(profesor.getApellidos());
		profesordBd.setCiudad(profesor.getCiudad());
		profesordBd.setDireccion(profesor.getDireccion());
		profesordBd.setEmail(profesor.getEmail());
		profesordBd.setTelefono(profesor.getTelefono());
		profesordBd.setN_documento(profesor.getN_documento());
		
	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(profesordBd));
	}
}
