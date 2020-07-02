package pe.gob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.model.Denuncias;

@Repository
public interface IDenunciasRepository extends JpaRepository<Denuncias, Integer>{
	
	@Query("from Denuncias d where d.Lugar like %:Lugar%")
	List<Denuncias> buscarLugar(@Param("Lugar") String lugar);
	
	@Query("from Denuncias d where d.delitos.nombreDelitos like %:nombreDelitos%")
	List<Denuncias> buscarDelito(@Param("nombreDelitos") String nameDueno);
	
	@Query("from Denuncias d where d.comisaria.nombreComisaria like %:nombreComisaria%")
	List<Denuncias> buscarComisaria(@Param("nombreComisaria") String nomComisaria);
	
}
