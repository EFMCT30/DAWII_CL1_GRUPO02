package pe.edu.cibertec.DAWII_CL1_GRUPO.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Cliente;
import pe.edu.cibertec.DAWII_CL1_GRUPO.service.ClienteService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;
    @GetMapping("/listar")
    @ResponseBody
    public List<Cliente> listarCliente(){return clienteService.listarCliente();}
}
