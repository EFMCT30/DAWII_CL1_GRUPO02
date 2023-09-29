package pe.edu.cibertec.DAWII_CL1_GRUPO.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Facturacion;
import pe.edu.cibertec.DAWII_CL1_GRUPO.request.FacturacionRequest;
import pe.edu.cibertec.DAWII_CL1_GRUPO.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_GRUPO.repository.FacturacionRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class FacturacionService {

    private FacturacionRepository facturacionRepository;

    public List<Facturacion> listarFacturacion(){
        return facturacionRepository.findAll();
    }

    public ResultadoResponse guardarFacturacion(FacturacionRequest facturacion){
        String mensaje = "Facturacion registrada correctamente";
        Boolean respuesta = true;
        try {
            Facturacion objFacturacion = new Facturacion();
            if(facturacion.getFacturacionId() > 0){
                objFacturacion.setFacturacionId(facturacion.getFacturacionId());
            }
            objFacturacion.setFechaFacturacion(facturacion.getFechaFacturacion());
            objFacturacion.setMontoTotal(facturacion.getMontoTotal());
        }catch (Exception ex){
            mensaje = "Facturacion no registrada";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

}
