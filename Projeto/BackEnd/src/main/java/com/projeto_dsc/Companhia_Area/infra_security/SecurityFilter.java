package com.projeto_dsc.Companhia_Area.infra_security;

import com.projeto_dsc.Companhia_Area.repository.UsuarioRepository;
import com.projeto_dsc.Companhia_Area.entity.UsuarioEntity;
import com.projeto_dsc.Companhia_Area.infra_security.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    TokenService tokenService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var token = this.recoverToken(request);
        System.out.println(token);
        if (token != null) {
            System.out.println("entrou");
            var email = tokenService.validateToken(token);
            var usuarioOptional = usuarioRepository.findByEmail(email);

            if (usuarioOptional.isPresent()) {
                UsuarioEntity usuario = usuarioOptional.get(); // Obtenha o usuário do Optional
                UserDetails user = usuario; // Atribua diretamente, se UsuarioEntity implementar UserDetails

                var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                System.out.println(authentication);
                System.out.println(token);
            }
        }

            filterChain.doFilter(request, response);
        }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
