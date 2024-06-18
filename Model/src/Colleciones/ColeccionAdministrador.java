package Colleciones;

import Entidades.Administrador;
import Entidades.Cliente;

import java.util.List;

public class ColeccionAdministrador {
    private final Coleccion<Administrador,String,String>coleccionAdministrador = new Coleccion<>();

    public boolean agregarAdministrador(Administrador administrador) {
        return coleccionAdministrador.agregar(administrador);
    }

    public Administrador buscarAdministrador(String dni) throws Exception {
        return coleccionAdministrador.buscar(dni);
    }

    public List<Administrador> filtrarAdministrador(String dni) {
        return coleccionAdministrador.filtrar(dni);
    }

    public boolean eliminarAdministrador(String dni) throws Exception {
        Administrador administrador = buscarAdministrador(dni);
        return coleccionAdministrador.eliminar(administrador);
    }


}
