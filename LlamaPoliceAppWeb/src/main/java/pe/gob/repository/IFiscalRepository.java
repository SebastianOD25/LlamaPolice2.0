package pe.gob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.model.Fiscal;

@Repository
public interface IFiscalRepository extends JpaRepository<Fiscal, Integer>{

	
	@Query("from Fiscal f where f.nombreFiscal like %:nombreFiscal%")
	List<Fiscal> buscarNombre(@Param("nombreFiscal") String nombreFiscal);
	
	
}
