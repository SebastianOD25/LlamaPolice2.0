package pe.gob.service;

import java.util.List;
import java.util.Optional;

import pe.gob.model.Fiscal;

public interface IFiscalService {

	public boolean insertar(Fiscal persona);
	public boolean modificar(Fiscal persona);
	public Optional<Fiscal> listarId(int idFiscal);
	public List<Fiscal> listar();
	public List<Fiscal> buscarNombre(String nombreFiscal);
	
}
