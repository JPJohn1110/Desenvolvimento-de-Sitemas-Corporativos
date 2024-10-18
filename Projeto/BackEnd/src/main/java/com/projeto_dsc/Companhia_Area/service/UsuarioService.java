package com.projeto_dsc.Companhia_Area.service;

import com.projeto_dsc.Companhia_Area.dto.UsuarioDTO;
import com.projeto_dsc.Companhia_Area.entity.UsuarioEntity;
import com.projeto_dsc.Companhia_Area.entity.UsuarioRole;
import com.projeto_dsc.Companhia_Area.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarTodos(){
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDTO::new).toList();
    }

    public void inserir(UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioRepository.save(usuarioEntity);
    }

    public void alterar(UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioRepository.save(usuarioEntity);
    }

    public void excluir(Long id) {
        UsuarioEntity usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }

    public List<UsuarioDTO> buscarPorRole(UsuarioRole role) {
        List<UsuarioEntity> usuarios = usuarioRepository.findByRole(role);
        return usuarios.stream().map(UsuarioDTO::new).toList();
    }

    public String buscarPorEmail(String email) {
        return usuarioRepository.findNomeByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email);
    }
    

}
