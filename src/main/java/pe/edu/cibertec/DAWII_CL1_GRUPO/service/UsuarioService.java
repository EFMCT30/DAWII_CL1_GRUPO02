package pe.edu.cibertec.DAWII_CL1_GRUPO.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Rol;
import pe.edu.cibertec.DAWII_CL1_GRUPO.entity.Usuario;
import pe.edu.cibertec.DAWII_CL1_GRUPO.repository.RolRepository;
import pe.edu.cibertec.DAWII_CL1_GRUPO.repository.UsuarioRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;

    private BCryptPasswordEncoder  bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private Usuario findUserByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public Usuario findUserByUserName(String username){
        return usuarioRepository.findByNomusuario(username);
    }

    //Para q el codigo se encripte
    public Usuario saveUser(Usuario usuario){
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        usuario.setActivo(true);
        Rol usuarioRol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        return usuarioRepository.save(usuario);
    }

}
