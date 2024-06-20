package Colleciones;

import Entidades.Administrador;
import Entidades.Mascota;
import Entidades.Veterinario;

import java.util.List;

public class ColeccionMascota {
    private final Coleccion<Mascota,String,String>coleccionMascota = new Coleccion<>();

    public boolean agregarMascota(Mascota mascota) {
        return coleccionMascota.agregar(mascota);
    }

    public Mascota buscarMascota(String dni) throws Exception {
        return coleccionMascota.encontrar(dni);
    }


    public List<Mascota> filtrarAdministrador(String dni) {
        return coleccionMascota.filtrar(dni);
    }

    public boolean eliminarMascota(String dni) throws Exception {
        Mascota mascota = buscarMascota(dni);
        return coleccionMascota.eliminar(mascota);
    }
}
