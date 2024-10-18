package com.example.pruebaEntelgy.model;

public class UsuarioDto {

    private String id;
    private String last_name;
    private String email;

    public UsuarioDto(String number, String alfaro, String mail) {
        this.id = id;
        this.last_name = last_name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
