package co.edu.ucentral.app.servicio.periodoAcademico.service;


import org.springframework.stereotype.Service;

import co.edu.ucentral.app.servicio.periodoAcademico.repository.PeriodoAcademicoRepository;
import co.edu.ucentral.common.periodoAcademico.model.PeriodoAcademico;
import co.edu.ucentral.servicio.common.service.CommonServiceImpl;

@Service
public class PeriodoAcademicoServiceImpl extends CommonServiceImpl<PeriodoAcademico, PeriodoAcademicoRepository> implements PeriodoAcademicoService {

}
