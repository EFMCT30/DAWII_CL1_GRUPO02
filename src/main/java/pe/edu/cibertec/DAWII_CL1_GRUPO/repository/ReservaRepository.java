package pe.edu.cibertec.DAWII_CL1_GRUPO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Reserva;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva , Long> {
}
