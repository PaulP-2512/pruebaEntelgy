package com.example.pruebaEntelgy.service;

import com.example.pruebaEntelgy.model.RespuestaApi;
import com.example.pruebaEntelgy.model.Usuario;
import com.example.pruebaEntelgy.model.UsuarioDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Value("${api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public UsuarioService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Usuario> obtenerUsuarios() {

        // Llamada GET a la API externa
        ResponseEntity<RespuestaApi> response = restTemplate.getForEntity(apiUrl, RespuestaApi.class);

        // Lista para almacenar los usuarios formateados
        List<Usuario> usuarios = new ArrayList<>();

        if (response.getBody() != null && response.getBody().getData() != null) {
            // Recorremos la lista de usuarios obtenida de la API y creamos nuevos objetos Usuario
            for (UsuarioDto usuarioDto : response.getBody().getData()) {
                // Aquí se está creando el objeto Usuario
                usuarios.add(new Usuario(usuarioDto.getId(), usuarioDto.getLast_name(), usuarioDto.getEmail()));
            }
        }

        return usuarios;

    }

}
