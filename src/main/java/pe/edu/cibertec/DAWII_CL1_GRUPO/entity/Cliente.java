package pe.edu.cibertec.DAWII_CL1_GRUPO.entity;

import jakarta.annotation.Nullable;
import lombok.*;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long cliente_id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "fecha_registro")
    @Nullable
    private Date fechaRegistro ;
    @Nullable
    @Column(name = "activo")
    private boolean activo;
    @Nullable
    @Column(name = "preferencias")
    private String preferencias;
    @ManyToOne
    @JoinColumn(name = "id_Pais")
    private Pais pais;


}
