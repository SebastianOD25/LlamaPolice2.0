package pe.gob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.model.Delitos;

@Repository
public interface DelitosRepository extends JpaRepository<Delitos, Integer>{
	
	@Query("from Delitos c where c.nombreDelitos like %:nombreDelitos%")
	List<Delitos> buscarNombre(@Param("nombreDelitos") String nombreDelitos);
	
}
