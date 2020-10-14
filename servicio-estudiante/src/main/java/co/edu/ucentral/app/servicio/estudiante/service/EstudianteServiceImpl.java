package co.edu.ucentral.app.servicio.estudiante.service;


import org.springframework.stereotype.Service;

import co.edu.ucentral.app.servicio.estudiante.repository.EstudianteRepository;
import co.edu.ucentral.common.estudiante.model.Estudiante;
import co.edu.ucentral.servicio.common.service.CommonServiceImpl;

@Service
public class EstudianteServiceImpl extends CommonServiceImpl<Estudiante, EstudianteRepository> implements EstudianteService {

}
