package pe.edu.cibertec.DAWII_CL1_GRUPO.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_GRUPO.model.bd.Habitacion;
import pe.edu.cibertec.DAWII_CL1_GRUPO.repository.HabitacionRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class HabitacionService {

    private HabitacionRepository habitacionRepository;

    public List<Habitacion> listarHabitaciones(){
        return habitacionRepository.findAll();
    }

}
