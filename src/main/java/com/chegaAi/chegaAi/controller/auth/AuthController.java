package com.chegaAi.chegaAi.controller.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chegaAi.chegaAi.config.security.JwtUtil;
import com.chegaAi.chegaAi.dto.LoginRequestDto;
import com.chegaAi.chegaAi.dto.LoginResponseDto;
import com.chegaAi.chegaAi.model.Usuario;
import com.chegaAi.chegaAi.services.UsuarioService;


@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto login) {
        Optional<Usuario> usuarioOpt = usuarioService.buscarPorEmail(login.getEmail());

        if (usuarioOpt.isPresent() && usuarioOpt.get().getSenha().equals(login.getSenha())) {
            String token = jwtUtil.generateToken(usuarioOpt.get().getEmail());
            return ResponseEntity.ok(new LoginResponseDto(token));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");
    }
}

