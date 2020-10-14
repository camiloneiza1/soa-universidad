package co.edu.ucentral.app.servicio.pregunta.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.servicio.pregunta.service.PreguntaService;
import co.edu.ucentral.common.pregunta.model.OpcionesPregunta;
import co.edu.ucentral.common.pregunta.model.Pregunta;
import co.edu.ucentral.servicio.common.controller.CommonController;

@RestController
public class PreguntaController extends CommonController<Pregunta, PreguntaService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Pregunta pregunta, BindingResult result, @PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Pregunta> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Pregunta preguntadBd = optional.get();
		preguntadBd.setEnunciado(pregunta.getEnunciado());
		preguntadBd.setFoto(pregunta.getFoto());
		preguntadBd.setTipoRespuesta(pregunta.getTipoRespuesta());
		preguntadBd.setPuntos(pregunta.getPuntos());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(preguntadBd));
	}
	
	@PutMapping("/{id}/addOpcion-Pregunta")
	public ResponseEntity<?> asignarItemFactura(@RequestBody OpcionesPregunta opcionesPregunta, @PathVariable Long id){
		Optional<Pregunta> optional = this.service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Pregunta preguntaBd = optional.get();
		preguntaBd.addOpcion(opcionesPregunta);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(preguntaBd));
	}
	
	@PutMapping("/{id}/removeOpcion-Pregunta")
	public ResponseEntity<?> eliminarItemFactura(@RequestBody OpcionesPregunta opcionesPregunta, @PathVariable Long id){
		Optional<Pregunta> optional = this.service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Pregunta preguntaBd = optional.get();
		preguntaBd.removeOpcion(opcionesPregunta);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(preguntaBd));
	}
}
