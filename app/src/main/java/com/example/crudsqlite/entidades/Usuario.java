package com.example.crudsqlite.entidades;

public class Usuario {
    private Integer id;
    private String nombre;
    private String telefono;
    private String deporte;

    public Usuario(Integer id, String nombre, String telefono,String deporte) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.deporte = deporte;
    }

    public Usuario() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
}
