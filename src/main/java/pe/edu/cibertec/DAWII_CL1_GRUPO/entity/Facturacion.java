package pe.edu.cibertec.DAWII_CL1_GRUPO.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facturaciones")
public class Facturacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facturacion_id")
    private Long facturacion_id;

    @Column(name = "fecha_facturacion")
    private Date fecha_facturacion;

    @Column(name = "monto_total")
    private BigDecimal monto_total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
