package pe.gob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.gob.model.Roles;

@Repository
public interface IRolRepository extends JpaRepository<Roles, Integer>{

}
