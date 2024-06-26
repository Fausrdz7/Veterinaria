package Entidades;

import Enumeraciones.Rol;

public class Usuario {

    private String contraseña;
    private String dni;
    private Rol role;
    private String nombre;
    private String apellido;
    private boolean estado; /// true esta dado de alta, false esta dado de baja.


    public Usuario(String contraseña, String dni, Rol role, String nombre, String apellido) {
        this.contraseña = contraseña;
        this.dni = dni;
        this.role = role;
        this.nombre = nombre;
        this.apellido = apellido;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Rol getRole() {
        return role;
    }

    public void setRole(Rol role) {
        this.role = role;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                ", contraseña='" + contraseña + '\'' +
                ", dni='" + dni + '\'' +
                ", role=" + role +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", estado=" + estado +
                '}';
    }

}