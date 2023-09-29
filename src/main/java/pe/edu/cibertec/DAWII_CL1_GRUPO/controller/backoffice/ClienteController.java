package pe.edu.cibertec.DAWII_CL1_GRUPO.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Cliente;
import pe.edu.cibertec.DAWII_CL1_GRUPO.request.ClienteRequest;
import pe.edu.cibertec.DAWII_CL1_GRUPO.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_GRUPO.service.ClienteService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/client")
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaClientes",
                clienteService.listarClientes());
        return "backoffice/client/frmMantClient";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }
    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarCliente(
            @RequestBody ClienteRequest clienteRequest
            ){
        return clienteService.guardarCliente(clienteRequest);
    }
}
