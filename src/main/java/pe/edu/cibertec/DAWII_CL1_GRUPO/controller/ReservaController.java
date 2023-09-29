package pe.edu.cibertec.DAWII_CL1_GRUPO.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Reserva;
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

}
