package pe.edu.cibertec.DAWII_CL1_GRUPO.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.DAWII_CL1_GRUPO.model.bd.Habitacion;
import pe.edu.cibertec.DAWII_CL1_GRUPO.service.HabitacionService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("habitacion")
public class HabitacionController {

    private HabitacionService habitacionService;

    @GetMapping("/frmMantHabitacion")
    public String index(Model model){
        model.addAttribute("listaHabitaciones",habitacionService.listarHabitaciones());
        return "/habitacion/frmMantHabitacion";
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<Habitacion> listarHabitaciones(){
        return habitacionService.listarHabitaciones();
    }

}
