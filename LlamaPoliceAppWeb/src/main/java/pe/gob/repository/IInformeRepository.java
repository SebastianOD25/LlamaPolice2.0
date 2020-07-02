package pe.gob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.model.Informe;

@Repository
public interface IInformeRepository extends JpaRepository<Informe, Integer>{
	
	@Query("from Informe i where i.Respuesta like %:Respuesta%")
	List<Informe> buscarInforme(@Param("Respuesta") String Respuesta);
	
}
