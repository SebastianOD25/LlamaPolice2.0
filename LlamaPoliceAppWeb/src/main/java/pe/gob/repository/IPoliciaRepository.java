package pe.gob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.gob.model.Policia;

public interface IPoliciaRepository extends JpaRepository<Policia, Integer>{
	
	@Query("from Policia p where p.nombrePolicia like %:nombrePolicia%")
	List<Policia> buscarNombre(@Param("nombrePolicia") String nombrePolicia);
	
	@Query("from Policia p where p.comisaria.nombreComisaria like %:nombreComisaria%")
	List<Policia> buscarComisaria(@Param("nombreComisaria") String nomComisaria);
	
}
