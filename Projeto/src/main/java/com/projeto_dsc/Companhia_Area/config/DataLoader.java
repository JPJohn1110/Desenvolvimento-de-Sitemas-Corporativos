package com.projeto_dsc.Companhia_Area.config;

import com.projeto_dsc.Companhia_Area.dto.UsuarioDTO;
import com.projeto_dsc.Companhia_Area.entity.UsuarioEntity;
import com.projeto_dsc.Companhia_Area.entity.UsuarioRole;
import com.projeto_dsc.Companhia_Area.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    String encryptedPassword = new BCryptPasswordEncoder().encode("KeLToNmd20");

    @Override
    public void run(String... args) {
        UsuarioEntity admin = new UsuarioEntity();
        admin.setRole(UsuarioRole.ADMIN);
        admin.setCodigoAcesso("123456");
        admin.setEmail("keltonm6@gmail.com");
        admin.setNome("Kelton Martins Dias");
        admin.setCpf("123456789-98");
        admin.setTelefone("38991317144");
        admin.setSenha(encryptedPassword);
        usuarioRepository.save(admin);
    }
}