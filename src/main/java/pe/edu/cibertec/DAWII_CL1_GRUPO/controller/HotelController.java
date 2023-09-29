package pe.edu.cibertec.DAWII_CL1_GRUPO.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.DAWII_CL1_GRUPO.model.bd.Hotel;
import pe.edu.cibertec.DAWII_CL1_GRUPO.service.HotelService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/hotel")
public class HotelController {
    private HotelService hotelService;

    @GetMapping("/listar")
    @ResponseBody
    public List<Hotel> listarHoteles(){
        return hotelService.listarHoteles();
    }
}
