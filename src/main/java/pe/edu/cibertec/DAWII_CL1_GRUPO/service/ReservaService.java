package pe.edu.cibertec.DAWII_CL1_GRUPO.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Reserva;
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




        }catch (Exception ex){
            mensaje = "Reserva no registrado";
            respuesta = false;
        }


        return ResultadoResponse.builder().build();
    }
}

