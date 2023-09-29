package pe.edu.cibertec.DAWII_CL1_GRUPO.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hoteles")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotelId")
    private Long hotelId;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "estrellas")
    private int estrellas;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_construccion")
    private Date fechaConstruccion;
    @Column(name = "categoria")
    private String categoria;

}

