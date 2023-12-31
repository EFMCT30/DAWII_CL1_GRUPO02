package pe.edu.cibertec.DAWII_CL1_GRUPO.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Habitacion;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Hotel;
import pe.edu.cibertec.DAWII_CL1_GRUPO.request.HabitacionRequest;
import pe.edu.cibertec.DAWII_CL1_GRUPO.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_GRUPO.repository.HabitacionRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class HabitacionService {

    private HabitacionRepository habitacionRepository;

    public List<Habitacion> listarHabitaciones(){
        return habitacionRepository.findAll();
    }

    public ResultadoResponse guardarHabitacion(HabitacionRequest habitacion){
        String mensaje = "Habitacion registrado correctamente";
        Boolean respuesta = true;
        try{
            Habitacion objHab = new Habitacion();
            if(habitacion.getHabitacion_Id() > 0){
                objHab.setHabitacion_Id(habitacion.getHabitacion_Id());
            }
            objHab.setNumeroHabitacion(habitacion.getNumeroHabitacion());
            objHab.setTipo(habitacion.getTipo());
            objHab.setCapacidad(habitacion.getCapacidad());
            objHab.setPrecioNoche(habitacion.getPrecioNoche());
            Boolean disponible = false;
            if(habitacion.getDisponible() != null) {
                disponible = habitacion.getDisponible();
            }
            objHab.setDisponible(disponible);
            objHab.setFecha_ultima_mantenimiento(habitacion.getFecha_ultima_mantenimiento());
            Hotel hotel = new Hotel();
            hotel.setHotelId(habitacion.getHotelId());
            objHab.setHotel(hotel);
            habitacionRepository.save(objHab);
        }catch (Exception ex){
            mensaje = "Habitacion no registrada";
            respuesta = false;
            System.out.println(habitacion);
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

}
