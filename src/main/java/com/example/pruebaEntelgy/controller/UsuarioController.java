package com.example.pruebaEntelgy.controller;

import com.example.pruebaEntelgy.model.Usuario;
import com.example.pruebaEntelgy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<List<String>> reestructurarUsuarios() {

        // Obtener los usuarios en el formato adecuado
        List<Usuario> usuarios = usuarioService.obtenerUsuarios();

        // Crear la lista con el formato "<id>|<last_name>|<email>"
        List<String> usuariosFormateados = usuarios.stream()
                .map(usuario -> usuario.getId() + "|" + usuario.getLastName() + "|" + usuario.getEmail())
                .toList();

        // Devolver la lista en el campo "data" como respuesta JSON
        return ResponseEntity.ok(usuariosFormateados);

    }

}
