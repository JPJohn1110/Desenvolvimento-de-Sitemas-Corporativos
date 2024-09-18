    package com.projeto_dsc.Companhia_Area.entity;

import com.projeto_dsc.Companhia_Area.dto.UsuarioDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table (name = "USUARIO")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String nome;

    @Column (nullable = false, unique = true)
    private String login;

    @Column (nullable = false)
    private String genero; //Tem que fazer no DTO, controller e Ser


    @Column (nullable = false)
    private String tipoDocumento; //Tem que fazer no DTO, controller e Ser

    @Column (nullable = false)
    private Long numeroDocumento; //Tem que fazer no DTO, controller e Ser


    @Column (nullable = false)
    private String cep; //Tem que fazer no DTO, controller e Ser

    @Column (nullable = false)
    private String senha;

    @Column (nullable = false)
    private String cpf;

    @Column (nullable = false)
    private String email;

   

    @Column (nullable = false)
    private String telefone;

    @Column (nullable = false)
    private String dataNascimento;
    

    public UsuarioEntity(UsuarioDTO usuario) {
        BeanUtils.copyProperties(usuario, this);
    }
    public UsuarioEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return id == that.id;
    }
}
