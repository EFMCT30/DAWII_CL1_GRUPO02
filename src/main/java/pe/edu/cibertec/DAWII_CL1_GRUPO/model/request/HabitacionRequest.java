package pe.edu.cibertec.DAWII_CL1_GRUPO.model.request;


import lombok.Data;
import pe.edu.cibertec.DAWII_CL1_GRUPO.model.bd.Hotel;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class HabitacionRequest {

    private Long habitacionId;
    private Integer numeroHabitacion;
    private String tipo;
    private Integer capacidad;
    private BigDecimal precioNoche;
    private Boolean disponible;
    private Date fecha_ultima_mantenimiento;
    private Long hotelId;

}
