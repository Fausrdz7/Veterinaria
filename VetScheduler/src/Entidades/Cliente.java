package Entidades;

import Entidades.Mascota;
import Entidades.Usuario;
import Enumeraciones.Rol;
import Interfaces.Buscable;
import Interfaces.Filtrable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cliente extends Usuario implements Filtrable<String>, Buscable<String>, Comparable<Cliente> {
    private List <Mascota>mascotas = new ArrayList<>() ;

    public Cliente(String contraseña, String dni, Rol rol, String nombre, String apellido) {
        super(contraseña, dni, rol, nombre, apellido);
    }


    // Agregar una mascota
    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    // Listar todas las mascotas del cliente
    public List<Mascota> listarMascotas() {
        return mascotas;
    }

    // Buscar una mascota por nombre
    public Mascota buscarMascotaPorNombre(String nombre) {
        for (Mascota mascota : mascotas) {
            if (mascota.getNombre().equalsIgnoreCase(nombre)) {
                return mascota;
            }
        }
        return null; // Retorna null si no se encuentra la mascota
    }

    // Eliminar una mascota por nombre
    public boolean eliminarMascotaPorNombre(String nombre) {
        Iterator<Mascota> iterator = mascotas.iterator();
        while (iterator.hasNext()) {
            Mascota mascota = iterator.next();
            if (mascota.getNombre().equalsIgnoreCase(nombre)) {
                iterator.remove();
                return true; // Retorna true si se encontró y eliminó la mascota
            }
        }
        return false; // Retorna false si no se encontró la mascota
    }

    @Override
    public boolean filtrar(String criterio) {
        return false;
    }

    @Override
    public boolean buscar(String criterio) {
        return criterio.equals( this.getDni() );
    }

    @Override
    public int compareTo(Cliente obj) {
        return this.getDni().compareTo(obj.getDni());
    }
}
