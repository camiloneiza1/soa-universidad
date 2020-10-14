package co.edu.ucentral.app.servicio.facultad.service;

import org.springframework.stereotype.Service;

import co.edu.ucentral.app.servicio.facultad.repository.FacultadRepository;
import co.edu.ucentral.common.facultad.model.Facultad;
import co.edu.ucentral.servicio.common.service.CommonServiceImpl;

@Service
public class FacultadServiceImpl extends CommonServiceImpl<Facultad, FacultadRepository> implements FacultadService {


}
