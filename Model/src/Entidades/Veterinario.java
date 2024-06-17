package Entidades;

import Entidades.Usuario;
import Enumeraciones.Rol;
import Interfaces.Buscable;
import Interfaces.Filtrable;

public class Veterinario extends Usuario implements Filtrable<String>, Buscable<String> {
    private String matricula;

    public Veterinario(String nombreUsuario, String contraseña, String dni, Rol role, String nombre, String apellido, String matricula) {
        super(nombreUsuario, contraseña, dni, role, nombre, apellido);
        this.matricula = matricula;
    }

    @Override
    public boolean buscar(String criterio) {
        return this.matricula.contains(criterio);
    }

    @Override
    public boolean filtrar(String criterio) {
        return this.getNombre().equalsIgnoreCase(criterio);
    }
}