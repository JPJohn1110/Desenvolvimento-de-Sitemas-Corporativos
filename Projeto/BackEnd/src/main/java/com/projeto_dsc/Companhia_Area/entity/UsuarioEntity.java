package com.projeto_dsc.Companhia_Area.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.catalina.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.thymeleaf.expression.Objects;
import com.projeto_dsc.Companhia_Area.dto.UsuarioDTO;
import java.util.Collection;
import java.util.List;

@Table(name = "usuario")
@Entity(name = "usuario")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioEntity implements UserDetails {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id_;

@Column (nullable = false)
private String nome;

@Column (nullable = false)
private String senha;

@Column (nullable = false)
private String email;

@Enumerated(EnumType.STRING)
@Column (nullable = false)
private UsuarioRole role;

@Column (nullable = false)
private String telefone;

@Column (nullable = false, unique = true)
private String codigoAcesso;

public String getCodigoAcesso() {
    return codigoAcesso;
}
@Column (nullable = false, unique = true)
private String cpf;

public UsuarioEntity(UsuarioDTO usuario) {
     if (this.role == null) {
        this.role = UsuarioRole.USUARIO; 
    }
}
public UsuarioEntity() {

}


public UsuarioEntity(String email, String senha, UsuarioRole role, String cpf, String codigoAcesso,  String nome, String telefone ){
    this.email = email;
    this.senha = senha;
    this.role = role;
    this.cpf = cpf;
    this.nome = nome;
    this.telefone = telefone;
    this.codigoAcesso = codigoAcesso;

}


@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UsuarioEntity that = (UsuarioEntity) o;
    return id_ == that.id_;
}
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    if(this.role == UsuarioRole.ADMIN) return List.of(new SimpleGrantedAuthority("UsuarioRole.ADMIN"), new SimpleGrantedAuthority("UsuarioRole.USUARIO"));
   
    else return List.of(new SimpleGrantedAuthority("UsuarioRole.USUARIO"));

}


@Override
public String getPassword() {
    return senha;
}

@Override
public String getUsername() {
    return email;
}

}
