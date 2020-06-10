package pe.gob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.model.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer>{
	
	@Query("from Persona p where p.nombrePersona like %:nombrePersona%")
	List<Persona> buscarNombre(@Param("nombrePersona") String nombrePersona);
	
}
