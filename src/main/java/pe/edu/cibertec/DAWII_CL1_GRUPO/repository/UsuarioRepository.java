package pe.edu.cibertec.DAWII_CL1_GRUPO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Usuario findByEmail(String email);
    Usuario findByNomusuario(String nomusuario);
}
