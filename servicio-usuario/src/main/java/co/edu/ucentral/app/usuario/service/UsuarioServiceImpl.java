package co.edu.ucentral.app.usuario.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.app.usuario.model.Usuario;
import co.edu.ucentral.app.usuario.repository.UsuarioRepository;
import co.edu.ucentral.servicio.common.service.CommonServiceImpl;

@Service
public class UsuarioServiceImpl extends CommonServiceImpl<Usuario, UsuarioRepository> implements UsuarioService {

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		return repository.findByUsername(username);
	}

}
