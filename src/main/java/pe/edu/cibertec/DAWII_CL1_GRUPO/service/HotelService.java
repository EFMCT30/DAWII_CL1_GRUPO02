package pe.edu.cibertec.DAWII_CL1_GRUPO.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Hotel;
import pe.edu.cibertec.DAWII_CL1_GRUPO.repository.HotelRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class HotelService {

    private HotelRepository hotelRepository;

    public List<Hotel> listarHoteles(){
        return hotelRepository.findAll();
    }

}
