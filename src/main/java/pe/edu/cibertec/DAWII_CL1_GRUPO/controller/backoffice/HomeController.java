package pe.edu.cibertec.DAWII_CL1_GRUPO.controller.backoffice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String index(){
        return "home";
    }

}