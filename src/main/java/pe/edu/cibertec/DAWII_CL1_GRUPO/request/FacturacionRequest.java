package pe.edu.cibertec.DAWII_CL1_GRUPO.request;

import lombok.Data;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Cliente;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class FacturacionRequest {

    private Date fecha_facturacion;
    private BigDecimal monto_total;
    private Long cliente_id;
    private Long facturacion_id;
}