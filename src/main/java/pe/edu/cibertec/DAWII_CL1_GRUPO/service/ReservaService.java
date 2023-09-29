package pe.edu.cibertec.DAWII_CL1_GRUPO.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Reserva;
import pe.edu.cibertec.DAWII_CL1_GRUPO.repository.ReservaRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ReservaService {
 private ReservaRepository reservaRepository;
    public List<Reserva> listarReservas(){
        return reservaRepository.findAll();
    }
}
