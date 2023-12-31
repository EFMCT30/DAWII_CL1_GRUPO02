package pe.edu.cibertec.DAWII_CL1_GRUPO.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
@Entity
@Table( name = "habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habitacion_id")
    private Long habitacion_Id;
    @Column(name = "numeroHabitacion")
    private int numeroHabitacion;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "capacidad")
    private int capacidad;
    @Column(name = "precioNoche")
    private BigDecimal precioNoche;
    @Column(name = "disponible")
    private boolean disponible;
    @Column(name = "fecha_ultima_mantenimiento")
    private Date fecha_ultima_mantenimiento;
    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;
}
