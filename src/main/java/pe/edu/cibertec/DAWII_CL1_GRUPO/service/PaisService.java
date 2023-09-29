package pe.edu.cibertec.DAWII_CL1_GRUPO.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Cliente;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Pais;
import pe.edu.cibertec.DAWII_CL1_GRUPO.repository.ClienteRepository;
import pe.edu.cibertec.DAWII_CL1_GRUPO.repository.PaisRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PaisService {
    private PaisRepository paisRepository;

    public List<Pais> listarPaises(){
        return paisRepository.findAll();
    }
}
