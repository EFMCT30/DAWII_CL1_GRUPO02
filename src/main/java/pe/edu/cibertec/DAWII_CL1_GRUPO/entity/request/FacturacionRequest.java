package pe.edu.cibertec.DAWII_CL1_GRUPO.entity.request;

import lombok.Data;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Cliente;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class FacturacionRequest {

    private Date fechaFacturacion;
    private BigDecimal montoTotal;
    private Cliente cliente;
    private Long facturacionId;
}
