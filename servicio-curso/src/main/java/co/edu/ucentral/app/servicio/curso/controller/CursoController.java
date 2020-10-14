package co.edu.ucentral.app.servicio.curso.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.servicio.curso.service.CursoService;
import co.edu.ucentral.common.curso.model.Curso;
import co.edu.ucentral.servicio.common.controller.CommonController;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Curso curso, BindingResult result, @PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Curso> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursodBd = optional.get();
		cursodBd.setNombre(curso.getNombre());
		cursodBd.setDescripcion(curso.getDescripcion());
		cursodBd.setCodigo(curso.getCodigo());
		cursodBd.setPeriodoAcademico(curso.getPeriodoAcademico());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursodBd));
	}
}
