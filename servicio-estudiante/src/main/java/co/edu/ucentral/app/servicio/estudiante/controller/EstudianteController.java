package co.edu.ucentral.app.servicio.estudiante.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.servicio.estudiante.service.EstudianteService;
import co.edu.ucentral.common.estudiante.model.Estudiante;
import co.edu.ucentral.servicio.common.controller.CommonController;

@RestController
public class EstudianteController extends CommonController<Estudiante, EstudianteService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Estudiante estudiante, BindingResult result, @PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Estudiante> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Estudiante estudiantedBd = optional.get();
		estudiantedBd.setNombres(estudiante.getNombres());
		estudiantedBd.setApellidos(estudiante.getApellidos());
		estudiantedBd.setCiudad(estudiante.getCiudad());
		estudiantedBd.setDireccion(estudiante.getDireccion());
		estudiantedBd.setEmail(estudiante.getEmail());
		estudiantedBd.setTelefono(estudiante.getTelefono());
		estudiantedBd.setN_documento(estudiante.getN_documento());	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(estudiantedBd));
	}
}
