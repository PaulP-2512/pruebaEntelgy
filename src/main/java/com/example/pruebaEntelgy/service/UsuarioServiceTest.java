package com.example.pruebaEntelgy.service;

import com.example.pruebaEntelgy.model.RespuestaApi;
import com.example.pruebaEntelgy.model.Usuario;
import com.example.pruebaEntelgy.model.UsuarioDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService; // Servicio a probar

    @Mock
    private RestTemplate restTemplate; // Mock de RestTemplate

    @BeforeEach
    public void setup() throws NoSuchFieldException, IllegalAccessException {
        // Inicializa los mocks antes de cada prueba
        MockitoAnnotations.openMocks(this);

        // Configurar el valor de apiUrl directamente
        Field apiUrlField = UsuarioService.class.getDeclaredField("apiUrl");
        apiUrlField.setAccessible(true); // Permitir acceso a campo privado
        apiUrlField.set(usuarioService, "https://reqres.in/api/users"); // Establecer el valor
    }

    @Test
    public void testObtenerUsuarios() {

        //Preparar los datos mock
        UsuarioDto usuarioDto = new UsuarioDto("1", "Alfaro", "alfaro@correo.com");
        RespuestaApi respuestaApi = new RespuestaApi(List.of(usuarioDto));

        //Configurar el comportamiento del mock
        when(restTemplate.getForEntity("https://reqres.in/api/users", RespuestaApi.class))
                .thenReturn(ResponseEntity.ok(respuestaApi));

        // Llamar al metodo del servicio
        List<Usuario> usuarios = usuarioService.obtenerUsuarios();

        //Verificar los resultados
        assertEquals(1, usuarios.size(), "Debería haber un usuario en la lista.");
        assertEquals("Alfaro", usuarios.get(0).getLastName(), "El apellido del usuario debería ser Alfaro.");
        assertEquals("alfaro@correo.com", usuarios.get(0).getEmail(), "El correo del usuario debería ser alfaro@correo.com.");
        // Si 'Usuario' tiene un campo 'id', también puedes verificarlo
        assertEquals("1", usuarios.get(0).getId(), "El ID del usuario debería ser 1.");

    }

}
