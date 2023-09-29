package pe.edu.cibertec.DAWII_CL1_GRUPO.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Reserva;
import pe.edu.cibertec.DAWII_CL1_GRUPO.repository.ReservaRepository;

import java.util.List;

@Service
public class ReservaService {
    private ReservaRepository reservaRepository;

    public List<Reserva> listarReservar(){
        return reservaRepository.findAll();
    }
}

