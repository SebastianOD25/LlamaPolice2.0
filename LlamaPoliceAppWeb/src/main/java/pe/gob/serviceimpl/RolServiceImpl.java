package pe.gob.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.model.Roles;
import pe.gob.repository.IRolRepository;
import pe.gob.service.IRolesService;

@Service
public class RolServiceImpl implements IRolesService{

	@Autowired
	private IRolRepository rRol;
	
	@Override
	@Transactional(readOnly = true)
	public List<Roles> listar() {
		return rRol.findAll();
	}

}
