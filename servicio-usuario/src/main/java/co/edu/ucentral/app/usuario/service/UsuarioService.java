package co.edu.ucentral.app.usuario.service;

import co.edu.ucentral.commonusuarios.model.Usuario;
import co.edu.ucentral.servicio.common.service.CommonService;

public interface UsuarioService extends CommonService<Usuario> {
	public Usuario findByUsername(String username);
}
