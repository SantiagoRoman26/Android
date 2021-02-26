package com.example.santiagoroman.modelo;

public class Docente {
    private String cedula;
    private String apellidos;
    private String nombres;

    public Docente(){

    }

    public Docente(String cedula, String apellidos, String nombres){
        this.cedula = cedula;
        this.apellidos = apellidos;
        this.nombres = nombres;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}
