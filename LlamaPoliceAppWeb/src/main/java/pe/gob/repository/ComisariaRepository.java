package pe.gob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.model.Comisaria;

@Repository
public interface ComisariaRepository extends JpaRepository<Comisaria, Integer>{
	
	@Query("from Comisaria c where c.nombreComisaria like %:nombreComisaria%")
	List<Comisaria> buscarNombre(@Param("nombreComisaria") String nombreComisaria);
	
}
