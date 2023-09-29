package pe.edu.cibertec.DAWII_CL1_GRUPO.request;

import jakarta.persistence.*;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Cliente;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.ReservaHabitacion;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class ReservaRequest {


    private Long reservaId;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado;
    private BigDecimal precioTotal;
    private Timestamp fechaCreacion;
    private String comentarios;
    private Long cliente;
    private Long reservaHabitaciones;
}
