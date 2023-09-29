package pe.edu.cibertec.DAWII_CL1_GRUPO.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Pais;
import pe.edu.cibertec.DAWII_CL1_GRUPO.service.PaisService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/pais")
public class PaisController {
    private PaisService paisService;

    @GetMapping("/listar")
    @ResponseBody
    public List<Pais> listarPaises(){
        return paisService.listarPaises();
    }
}
