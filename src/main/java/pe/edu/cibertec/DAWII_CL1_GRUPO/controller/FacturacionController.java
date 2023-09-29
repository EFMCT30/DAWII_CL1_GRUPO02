package pe.edu.cibertec.DAWII_CL1_GRUPO.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Facturacion;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.request.FacturacionRequest;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_GRUPO.service.FacturacionService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/facturacion")
public class FacturacionController {

    private FacturacionService facturacionService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaProductos",
                facturacionService.listarFacturacion());
        return "backoffice/facturacion/frmMantFacturacion";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<Facturacion> listarFacturacion(){
        return facturacionService.listarFacturacion();
    }
    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarFacturacion(
            @RequestBody FacturacionRequest facturacionRequest
    ){
        return facturacionService.guardarFacturacion(facturacionRequest);
    }
}
