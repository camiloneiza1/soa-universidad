package co.edu.ucentral.app.usuario.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

import co.edu.ucentral.app.usuario.model.Usuario;
import co.edu.ucentral.app.usuario.service.UsuarioService;
import co.edu.ucentral.servicio.common.service.CommonController;

@RestController
public class UsuarioController extends CommonController<Usuario, UsuarioService>{
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Usuario usuario, BindingResult result, @PathVariable Long id){
		Optional<Usuario> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Usuario usuariodBd = optional.get();
		usuariodBd.setNombre(usuario.getNombre());
		usuariodBd.setApellido(usuario.getApellido());
		usuariodBd.setEmail(usuario.getEmail());
		usuariodBd.setPassword(usuario.getPassword());
		usuariodBd.setRoles(usuario.getRoles());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuariodBd));
	}
	
	@GetMapping("/buscar-username")
	public ResponseEntity<?> verPorUsername(@RequestParam("username") String username){
		Usuario usuario = service.findByUsername(username);
		if(usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
		
	}

}
