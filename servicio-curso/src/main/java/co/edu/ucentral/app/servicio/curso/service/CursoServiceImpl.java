package co.edu.ucentral.app.servicio.curso.service;

import org.springframework.stereotype.Service;

import co.edu.ucentral.app.servicio.curso.repository.CursoRepository;
import co.edu.ucentral.common.curso.model.Curso;
import co.edu.ucentral.servicio.common.service.CommonServiceImpl;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

}
