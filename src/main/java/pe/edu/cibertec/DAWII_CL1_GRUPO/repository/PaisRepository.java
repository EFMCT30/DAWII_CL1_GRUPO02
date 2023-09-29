package pe.edu.cibertec.DAWII_CL1_GRUPO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais,Integer> {
}
