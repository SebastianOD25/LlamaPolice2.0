package pe.gob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.model.Reporte;

@Repository
public interface IReporteRepository extends JpaRepository<Reporte,Integer>{
	
	
	@Query("from Reporte r where r.policia.nombrePolicia like %:nombrePolicia%")
	List<Reporte> buscarPolicia(@Param("nombrePolicia") String nomPolicia);
	
	
}