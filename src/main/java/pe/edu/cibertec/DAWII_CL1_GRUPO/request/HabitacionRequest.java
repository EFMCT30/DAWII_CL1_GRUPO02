package pe.edu.cibertec.DAWII_CL1_GRUPO.request;


import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class HabitacionRequest {

    private Long habitacion_Id;
    private Integer numeroHabitacion;
    private String tipo;
    private Integer capacidad;
    private BigDecimal precioNoche;
    private Boolean disponible;
    private Date fecha_ultima_mantenimiento;
    private Long hotelId;

}
