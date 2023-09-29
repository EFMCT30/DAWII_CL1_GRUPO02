package pe.edu.cibertec.DAWII_CL1_GRUPO.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Habitacion;
import pe.edu.cibertec.DAWII_CL1_GRUPO.request.HabitacionRequest;
import pe.edu.cibertec.DAWII_CL1_GRUPO.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_GRUPO.service.HabitacionService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/habitacion")
public class HabitacionController {

    private HabitacionService habitacionService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaHabitaciones",habitacionService.listarHabitaciones());
        return "backoffice/habitacion/frmMantHabitacion";
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<Habitacion> listarHabitaciones(){
        return habitacionService.listarHabitaciones();
    }

    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarHabitacion(@RequestBody HabitacionRequest habitacionRequest){
        return habitacionService.guardarHabitacion(habitacionRequest);
    }

}
