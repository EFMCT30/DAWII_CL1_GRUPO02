package pe.edu.cibertec.DAWII_CL1_GRUPO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Facturacion;

@Repository
public interface FacturacionRepository
        extends JpaRepository<Facturacion, Integer> {
}
