package pe.edu.cibertec.DAWII_CL1_GRUPO.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long cliente_id;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    @Column(name = "fecha_registro")
    private Date fechaRegistro;
    private boolean activo;
    private String preferencias;


}
