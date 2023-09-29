package pe.edu.cibertec.DAWII_CL1_GRUPO.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Cliente;
import pe.edu.cibertec.DAWII_CL1_GRUPO.repository.ClienteRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    public List<Cliente> listarCliente(){return  clienteRepository.findAll();}
}
