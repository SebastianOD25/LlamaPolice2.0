package pe.gob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.gob.model.Fiscal;

public interface IFiscalRepository extends JpaRepository<Fiscal, Integer>{
	
	@Query("from Fiscal p where p.nombreFiscal like %:nombreFiscal%")
	List<Fiscal> buscarNombre(@Param("nombreFiscal") String nombreFiscal);
	
}