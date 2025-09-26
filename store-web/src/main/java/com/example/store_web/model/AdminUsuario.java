package com.example.store_web.model;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "admin_usuario")
public class AdminUsuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private Integer idAdmin;

    @Column(name= "usuario", nullable = false, unique = true, length = 50)
    private String usuario;

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;
    
}
