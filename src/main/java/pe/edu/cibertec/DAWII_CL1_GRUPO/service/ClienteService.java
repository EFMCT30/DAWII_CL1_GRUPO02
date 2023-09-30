package pe.edu.cibertec.DAWII_CL1_GRUPO.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Cliente;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Pais;
import pe.edu.cibertec.DAWII_CL1_GRUPO.repository.ClienteRepository;
import pe.edu.cibertec.DAWII_CL1_GRUPO.request.ClienteRequest;
import pe.edu.cibertec.DAWII_CL1_GRUPO.response.ResultadoResponse;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public ResultadoResponse guardarCliente(ClienteRequest client) {
        String mensaje = "Cliente registrado correctamente :V";
        Boolean respuesta = true;
        try {
            Cliente objClient = new Cliente();

            if (client.getCliente_id() > 0) {
                objClient.setCliente_id(client.getCliente_id());
            }
            objClient.setNombre(client.getNombre());
            objClient.setEmail(client.getEmail());
            objClient.setTelefono(client.getTelefono());
            objClient.setDireccion(client.getDireccion());

            // Obtén el país por su Id
            Pais pais = new Pais();
            pais.setId_pais(pais.getId_pais());

            // Asigna el país al cliente
            objClient.setPais(pais);

            clienteRepository.save(objClient);
        } catch (Exception ex) {
            mensaje = "Cliente no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }


}
