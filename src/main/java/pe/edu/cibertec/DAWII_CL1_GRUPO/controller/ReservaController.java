package pe.edu.cibertec.DAWII_CL1_GRUPO.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Reserva;
import pe.edu.cibertec.DAWII_CL1_GRUPO.request.ReservaRequest;
import pe.edu.cibertec.DAWII_CL1_GRUPO.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_GRUPO.service.ReservaService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;


    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listarReserva",reservaService.listarReservar());
        return "backoffice/reserva/frmMantReserva";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<Reserva> listarReserva(){
        return reservaService.listarReservar();
    }

    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarProducto(@RequestBody ReservaRequest reservaRequest){
        return  reservaService.guardarReserva(reservaRequest);
    }
}
