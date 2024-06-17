package Entidades;

import Entidades.Mascota;
import Entidades.Usuario;
import Enumeraciones.Rol;
import Interfaces.Buscable;
import Interfaces.Filtrable;

import java.util.List;

public class Cliente extends Usuario implements Filtrable<String>, Buscable<String> {
    private List <Mascota>mascotas;

    public Cliente(String nombreUsuario, String contraseña, String dni, Rol ro, String nombre, String apellido, List<Mascota> mascotas) {
        super(nombreUsuario, contraseña, dni, ro, nombre, apellido);
        this.mascotas = mascotas;
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
