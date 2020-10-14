package co.edu.ucentral.app.servicio.evaluacion.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.servicio.evaluacion.service.EvaluacionService;
import co.edu.ucentral.common.evaluacion.model.Evaluacion;
import co.edu.ucentral.common.evaluacion.model.EvaluacionPregunta;
import co.edu.ucentral.servicio.common.controller.CommonController;

@RestController
public class EvaluacionController extends CommonController<Evaluacion, EvaluacionService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Evaluacion evaluacion, BindingResult result, @PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Evaluacion> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Evaluacion evaluacionBd = optional.get();
		evaluacionBd.setNombre(evaluacion.getNombre());
		evaluacionBd.setTiempo(evaluacion.getTiempo());
		evaluacionBd.setPuntos(evaluacion.getPuntos());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(evaluacionBd));
	}
	
	@PutMapping("/{id}/addPregunta-Evaluacion")
	public ResponseEntity<?> asignarItemFactura(@RequestBody EvaluacionPregunta evaluacionPregunta, @PathVariable Long id){
		Optional<Evaluacion> optional = this.service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Evaluacion evaluacionBd = optional.get();
		evaluacionBd.addePregunta(evaluacionPregunta);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(evaluacionBd));
	}
	
	@PutMapping("/{id}/removePregunta-Evaluacion")
	public ResponseEntity<?> eliminarItemFactura(@RequestBody EvaluacionPregunta evaluacionPregunta, @PathVariable Long id){
		Optional<Evaluacion> optional = this.service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Evaluacion evaluacionBd = optional.get();
		evaluacionBd.removeePregunta(evaluacionPregunta);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(evaluacionBd));
	}
}
