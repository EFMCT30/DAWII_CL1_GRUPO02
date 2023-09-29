package pe.edu.cibertec.DAWII_CL1_GRUPO.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Cliente;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Reserva;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.UserEntity;
import pe.edu.cibertec.DAWII_CL1_GRUPO.repository.ClienteRepository;
import pe.edu.cibertec.DAWII_CL1_GRUPO.request.ClienteRequest;
import pe.edu.cibertec.DAWII_CL1_GRUPO.response.ResultadoResponse;

import java.util.List;


@AllArgsConstructor
@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public ResultadoResponse guardarCliente(ClienteRequest client){
        String mensaje = "Cliente registrado correctamente :V";
        Boolean respuesta = true;
        try {
            Cliente objClient = new Cliente();
            if (client.getClienteId() > 0) {
                objClient.setClienteId(client.getClienteId());
            }
            objClient.setNombre(client.getNombre());
            objClient.setEmail(client.getEmail());
            Reserva reserva = new Reserva();
            reserva.setReservaId(client.getReservaId());
            UserEntity userentity = new UserEntity();
            userentity.setId(client.getId());
            objClient.set(reserva);
            objClient.setUser(userentity);
            productRepository.save(objProduct);
        }catch (Exception ex){
            mensaje = "Producto no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

}
