package pe.gob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.gob.model.Usuarios;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuarios, Long>{
	public Usuarios findByUsername(String username);
}
