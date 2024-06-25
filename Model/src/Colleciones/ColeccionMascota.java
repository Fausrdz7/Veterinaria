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
        return coleccionMascota.buscar(dni);
    }

    public List<Mascota> filtrarAdministrador(String dni) {
        return coleccionMascota.filtrar(dni);
    }

    public boolean eliminarAdministrador(String dni) throws Exception {
        Mascota mascota = buscarMascota(dni);
        return coleccionMascota.eliminar(mascota);
    }

    public List<Mascota> getMascotasByClient(String dni) {
        return coleccionMascota.filtrar(dni);
    }
}
