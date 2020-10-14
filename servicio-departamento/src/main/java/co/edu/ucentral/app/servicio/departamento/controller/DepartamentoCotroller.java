package co.edu.ucentral.app.servicio.departamento.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.servicio.departamento.service.DepartamentoService;
import co.edu.ucentral.common.departamento.model.Departamento;
import co.edu.ucentral.servicio.common.controller.CommonController;

@RestController
public class DepartamentoCotroller extends CommonController<Departamento, DepartamentoService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Departamento departamento, BindingResult result, @PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Departamento> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Departamento departamentodBd = optional.get();
		departamentodBd.setNombre(departamento.getNombre());
		departamentodBd.setDescripcion(departamento.getDescripcion());
		departamentodBd.setFacultad(departamento.getFacultad());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(departamentodBd));
	}
}
