package com.example.pruebaEntelgy.model;

import java.util.List;

public class RespuestaApi {

    private List<UsuarioDto> data;

    public RespuestaApi() {
    }

    public RespuestaApi(List<UsuarioDto> data) {
        this.data = data;
    }

    public List<UsuarioDto> getData() {
        return data;
    }

    public void setData(List<UsuarioDto> data) {
        this.data = data;
    }

}
