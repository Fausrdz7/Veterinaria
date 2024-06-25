package Entidades;

import Entidades.Usuario;
import Enumeraciones.Rol;
import Interfaces.Buscable;
import Interfaces.Filtrable;

import java.util.ArrayList;
import java.util.List;

public class Veterinario extends Usuario implements Filtrable<String>, Buscable<String>, Comparable<Veterinario> {
    private String matricula;
    private List<Turno> turnos=new ArrayList<>();

    public Veterinario(String nombreUsuario, String contraseña, String dni, Rol role, String nombre, String apellido, String matricula,Turno turno) {
        super(nombreUsuario, contraseña, dni, role, nombre, apellido);
        this.matricula = matricula;
        this.turnos.add(turno);
    }

    @Override
    public boolean buscar(String criterio) {
        return this.getDni().contains(criterio);
    }

    @Override
    public boolean filtrar(String criterio) {
        return this.getNombre().equalsIgnoreCase(criterio);
    }

    @Override
    public int compareTo(Veterinario obj) {
        return this.getDni().compareTo(obj.getDni());
    }
}