package co.edu.ucentral.app.servicio.periodoAcademico.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.servicio.periodoAcademico.service.PeriodoAcademicoService;
import co.edu.ucentral.common.periodoAcademico.model.PeriodoAcademico;
import co.edu.ucentral.servicio.common.controller.CommonController;

@RestController
public class PeriodoAcademicoController extends CommonController<PeriodoAcademico, PeriodoAcademicoService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody PeriodoAcademico periodoAcademico, BindingResult result, @PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<PeriodoAcademico> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		PeriodoAcademico periodoAcademicoBd = optional.get();
		periodoAcademicoBd.setNombre(periodoAcademico.getNombre());
		periodoAcademicoBd.setEstado(periodoAcademico.getEstado());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(periodoAcademicoBd));
	}
}
