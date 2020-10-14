package co.edu.ucentral.app.servicio.profesor.service;

import org.springframework.stereotype.Service;

import co.edu.ucentral.app.servicio.profesor.repository.ProfesorRepository;
import co.edu.ucentral.common.profesor.model.Profesor;
import co.edu.ucentral.servicio.common.service.CommonServiceImpl;

@Service
public class ProfesorServiceImpl extends CommonServiceImpl<Profesor, ProfesorRepository> implements ProfesorService {

}
