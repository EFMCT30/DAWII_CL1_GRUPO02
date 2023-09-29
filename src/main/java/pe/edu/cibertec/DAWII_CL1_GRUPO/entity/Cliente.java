package pe.edu.cibertec.DAWII_CL1_GRUPO.entity;

import lombok.*;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long clienteId;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "fecha_registro")
    private Date fechaRegistro;
    @Column(name = "activo")
    private boolean activo;
    @Column(name = "preferencias")
    private String preferencias;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true, nullable = false)
    private UserEntity user; // Referencia al usuario
}
