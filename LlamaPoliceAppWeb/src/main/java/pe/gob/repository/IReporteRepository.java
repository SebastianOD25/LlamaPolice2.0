package pe.gob.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import pe.gob.model.Reporte;

@Repository
public interface IReporteRepository extends JpaRepository<Reporte, Integer>{
	
}
