package pe.edu.cibertec.DAWII_CL1_GRUPO.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facturacion_reserva")
public class FacturacionReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facturacion_reserva_id")
    private Long facturacionReservaId;

    @ManyToOne
    @JoinColumn(name = "facturacion_id")
    private Facturacion facturacion;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;
}