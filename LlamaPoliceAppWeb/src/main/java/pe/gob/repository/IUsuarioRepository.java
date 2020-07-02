package pe.gob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.model.Usuarios;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuarios, Integer>{
	
	public Usuarios findByUsercode(String usercode);
	@Query("from Usuarios u where u.usercode like %:usercode%")
	List<Usuarios> buscarCodigo(@Param("usercode") String usercode);
	
	
}
