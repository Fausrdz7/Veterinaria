package Entidades;

import Enumeraciones.Rol;
import Interfaces.Buscable;
import Interfaces.Filtrable;

public class Administrador extends Usuario implements Filtrable<String>, Buscable<String> {

    public Administrador(String nombreUsuario, String contraseña, String dni, Rol role, String nombre, String apellido) {
        super(nombreUsuario, contraseña, dni, role, nombre, apellido);
    }

    @Override
    public boolean filtrar(String criterio) {
        return false;
    }

    @Override
    public boolean buscar(String criterio) {
        return false;
    }
}
