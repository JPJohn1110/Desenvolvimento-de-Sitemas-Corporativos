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
    String encryptedPassword0 = new BCryptPasswordEncoder().encode("123456jP@");
    String encryptedPassword1 = new BCryptPasswordEncoder().encode("KeLToNmd20");

    @Override
    public void run(String... args) {
        UsuarioEntity admink = new UsuarioEntity();
        admink.setRole(UsuarioRole.ADMIN);
        admink.setCodigoAcesso("5BohEkEKUnJc");
        admink.setEmail("keltonm6@gmail.com");
        admink.setNome("Kelton Martins Dias");
        admink.setCpf("123456789-98");
        admink.setTelefone("38991317144");
        admink.setSenha(encryptedPassword1);
        usuarioRepository.save(admink);

        UsuarioEntity adminj = new UsuarioEntity();
        adminj.setRole(UsuarioRole.ADMIN);
        adminj.setCodigoAcesso("h67OBpYuGxp4");
        adminj.setEmail("jpsr.jpsantos@gmail.com");
        adminj.setNome("João Pedro Santos Rodrigues");
        adminj.setCpf("12858434603");
        adminj.setTelefone("38988299517");
        adminj.setSenha(encryptedPassword0);
        usuarioRepository.save(adminj);
    
    }

    
}