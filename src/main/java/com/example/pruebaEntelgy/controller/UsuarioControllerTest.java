package com.example.pruebaEntelgy.controller;

import com.example.pruebaEntelgy.model.Usuario;
import com.example.pruebaEntelgy.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
    }

    @Test
    public void testCrearUsuario() throws Exception {

        //Simular la respuesta del servicio
        List<Usuario> usuariosMock = List.of(new Usuario("1", "Alfaro", "alfaro@correo.com"));
        when(usuarioService.obtenerUsuarios()).thenReturn(usuariosMock);

        //Realiza la solicitud POST y verifica el código de estado
        mockMvc.perform(post("/api/usuarios")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()); // Verifica que el estado sea 200 - OK

    }

}
