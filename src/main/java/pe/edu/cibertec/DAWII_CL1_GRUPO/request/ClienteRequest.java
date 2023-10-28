package pe.edu.cibertec.DAWII_CL1_GRUPO.request;

import lombok.Data;

import java.util.Date;

@Data
public class ClienteRequest {
    private Long cliente_id;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private Boolean activo;
    private Integer id_pais;
}
