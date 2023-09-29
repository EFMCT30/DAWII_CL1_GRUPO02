package pe.edu.cibertec.DAWII_CL1_GRUPO.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.UserEntity;
import pe.edu.cibertec.DAWII_CL1_GRUPO.repository.UserEntityRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class UserEntityService {
    private UserEntityRepository userentityrepository;
    public List<UserEntity> listarUsuarios(){
        return userentityrepository.findAll();
    }
}
