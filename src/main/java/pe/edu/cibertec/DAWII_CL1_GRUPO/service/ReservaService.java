package pe.edu.cibertec.DAWII_CL1_GRUPO.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Cliente;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Reserva;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.ReservaHabitacion;
import pe.edu.cibertec.DAWII_CL1_GRUPO.repository.ReservaRepository;
import pe.edu.cibertec.DAWII_CL1_GRUPO.request.ReservaRequest;
import pe.edu.cibertec.DAWII_CL1_GRUPO.response.ResultadoResponse;

import java.util.List;

@AllArgsConstructor
@Service
public class ReservaService {


    private ReservaRepository reservaRepository;

    public List<Reserva> listarReservar(){
        return reservaRepository.findAll();
    }

    public ResultadoResponse  guardarReserva(ReservaRequest reserva){
        String mensaje = "Reserva registrada correctamente";
        Boolean respuesta = true;

        try {
            Reserva objReserva = new Reserva();
            if(reserva.getReservaId()>0){
                objReserva.setReservaId(reserva.getReservaId());
            }
            objReserva.setFechaInicio(reserva.getFechaInicio());
            objReserva.setFechaFin(reserva.getFechaFin());
            objReserva.setEstado(reserva.getEstado());
            objReserva.setPrecioTotal(reserva.getPrecioTotal());
            objReserva.setFechaCreacion(reserva.getFechaCreacion());
            objReserva.setComentarios(reserva.getComentarios());
            Cliente cliente= new Cliente();
            cliente.setClienteId(reserva.getCliente());
            ReservaHabitacion reservaHabitacion = new ReservaHabitacion();
            reservaHabitacion.setReservaHabitacionId(reserva.getReservaHabitaciones());
            objReserva.setCliente(cliente);
            objReserva.setReservaHabitaciones((List<ReservaHabitacion>) reservaHabitacion);
            reservaRepository.save(objReserva);

        }catch (Exception ex){
            mensaje = "Reserva no registrado";
            respuesta = false;
        }


        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}

