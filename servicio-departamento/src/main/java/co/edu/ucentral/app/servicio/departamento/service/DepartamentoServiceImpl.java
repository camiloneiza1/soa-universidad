package co.edu.ucentral.app.servicio.departamento.service;

import org.springframework.stereotype.Service;

import co.edu.ucentral.app.servicio.departamento.repository.DepartamentoRepository;
import co.edu.ucentral.common.departamento.model.Departamento;
import co.edu.ucentral.servicio.common.service.CommonServiceImpl;

@Service
public class DepartamentoServiceImpl extends CommonServiceImpl<Departamento, DepartamentoRepository> implements DepartamentoService {

}
