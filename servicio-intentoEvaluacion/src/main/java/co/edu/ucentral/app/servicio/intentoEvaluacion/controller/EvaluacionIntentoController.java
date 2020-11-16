package co.edu.ucentral.app.servicio.intentoEvaluacion.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.servicio.intentoEvaluacion.service.EvaluacionIntentoService;
import co.edu.ucentral.common.intentoEvaluacion.model.EvaluacionIntento;
import co.edu.ucentral.common.intentoEvaluacion.model.RespuestaPregunta;
import co.edu.ucentral.servicio.common.controller.CommonController;

@RestController
public class EvaluacionIntentoController extends CommonController<EvaluacionIntento, EvaluacionIntentoService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody EvaluacionIntento evaluacionIntento, BindingResult result, @PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<EvaluacionIntento> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		EvaluacionIntento evaluacionIntentoBd = optional.get();
		evaluacionIntentoBd.setEstudiante(evaluacionIntento.getEstudiante());
		evaluacionIntentoBd.setPuntos(evaluacionIntento.getPuntos());
		evaluacionIntentoBd.setCalificacion(evaluacionIntento.getCalificacion());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(evaluacionIntentoBd));
	}
	
	@PutMapping("/{id}/addOpcion-Pregunta")
	public ResponseEntity<?> asignarItemFactura(@RequestBody RespuestaPregunta respuestaPregunta, @PathVariable Long id){
		Optional<EvaluacionIntento> optional = this.service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		EvaluacionIntento evaluacionIntentoBd = optional.get();
		evaluacionIntentoBd.addrPregunta(respuestaPregunta);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(evaluacionIntentoBd));
	}
	
	@PutMapping("/{id}/removeOpcion-Pregunta")
	public ResponseEntity<?> eliminarItemFactura(@RequestBody RespuestaPregunta respuestaPregunta, @PathVariable Long id){
		Optional<EvaluacionIntento> optional = this.service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		EvaluacionIntento evaluacionIntentoBd = optional.get();
		evaluacionIntentoBd.removerPregunta(respuestaPregunta);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(evaluacionIntentoBd));
	}
	
	@GetMapping("/evaluacionesGrupo/{id}")
	public ResponseEntity<?> buscarEvaluacionesGrupo(@PathVariable Long id){
		List<EvaluacionIntento> lista = service.buscarEvaluacionGrupo(id);
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/evaluacionesEstudiante/{id}")
	public ResponseEntity<?> buscarEvaluacionesEstudiante(@PathVariable Long id){
		List<EvaluacionIntento> lista = service.buscarEvaluacionEstudiante(id);
		return ResponseEntity.ok(lista);
	}
}
