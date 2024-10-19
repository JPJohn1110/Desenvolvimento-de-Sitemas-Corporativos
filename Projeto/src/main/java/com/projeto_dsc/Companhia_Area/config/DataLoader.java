package com.projeto_dsc.Companhia_Area.config;

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
    String encryptedPassword0 = new BCryptPasswordEncoder().encode("123456Jp@");
    String encryptedPassword1 = new BCryptPasswordEncoder().encode("KeLToNmd20");

    @Override
    public void run(String... args) {
        if (usuarioRepository.findByEmail("keltonm6@gmail.com") == null) {
            UsuarioEntity adminKelton = new UsuarioEntity();
            adminKelton.setRole(UsuarioRole.ADMIN);
            adminKelton.setCodigoAcesso("5BohEkEKUnJc");
            adminKelton.setEmail("keltonm6@gmail.com");
            adminKelton.setNome("Kelton Martins Dias");
            adminKelton.setCpf("123456789-98");
            adminKelton.setTelefone("38991317144");
            adminKelton.setSenha(encryptedPassword1);
            usuarioRepository.save(adminKelton);
        }

        if (usuarioRepository.findByEmail("jpsr.jpsantos@gmail.com") == null) {
            UsuarioEntity adminJoao = new UsuarioEntity();
            adminJoao.setRole(UsuarioRole.ADMIN);
            adminJoao.setCodigoAcesso("h67OBpYuGxp4");
            adminJoao.setEmail("jpsr.jpsantos@gmail.com");
            adminJoao.setNome("João Pedro Santos Rodrigues");
            adminJoao.setCpf("128584346-03");
            adminJoao.setTelefone("38988299517");
            adminJoao.setSenha(encryptedPassword0);
            usuarioRepository.save(adminJoao);
        }

        if (usuarioRepository.findByEmail("prof.paulo.veloso@gmail.com") == null) {
            UsuarioEntity adminPaulo = new UsuarioEntity();
            adminPaulo.setRole(UsuarioRole.ADMIN);
            adminPaulo.setCodigoAcesso("t000BpYuGxa4");
            adminPaulo.setEmail("prof.paulo.veloso@gmail.com");
            adminPaulo.setNome("Paulo Veloso");
            adminPaulo.setCpf("89715434600");
            adminPaulo.setTelefone("38988299517");
            adminPaulo.setSenha(encryptedPassword0);
            usuarioRepository.save(adminPaulo);
        }
    }
}