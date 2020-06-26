package pe.gob.service;

import java.util.List;
import java.util.Optional;

import pe.gob.model.Fiscal;



public interface IFiscalService {
	
	public boolean insertar(Fiscal fiscal);
	public boolean modificar(Fiscal fiscal);
	public void eliminar(int idFiscal);
	public Optional<Fiscal> buscarId(int idFiscal);
	public Optional<Fiscal> listarId(int idFiscal);
	public List<Fiscal> listar();
	public List<Fiscal> buscarNombre(String nameFiscal);
	
}