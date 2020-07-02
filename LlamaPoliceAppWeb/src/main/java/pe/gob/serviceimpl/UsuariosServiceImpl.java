package pe.gob.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.model.Usuarios;
import pe.gob.repository.IUsuarioRepository;
import pe.gob.service.IUsuariosService;

@Service
public class UsuariosServiceImpl implements IUsuariosService{

	@Autowired
	private IUsuarioRepository dUsuario;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	@Transactional
	public boolean insertar(Usuarios usuario) {
		String encodedPassword = bCryptPasswordEncoder.encode(usuario.getPassword());
		usuario.setPassword(encodedPassword);
		Usuarios objUsuario = dUsuario.save(usuario);
		if (objUsuario == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public List<Usuarios> listar() {
		return dUsuario.findAll();
	}

}
