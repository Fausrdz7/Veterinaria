package Colleciones;

import Entidades.Administrador;
import Entidades.Cliente;
import Enumeraciones.Rol;

import java.io.*;
import java.util.List;

public class ColeccionAdministrador {
    private final Coleccion<Administrador,String,String>coleccionAdministrador = new Coleccion<>();

    public ColeccionAdministrador() {
        coleccionAdministrador.agregar(new Administrador("1234","111111", Rol.ADMIN,"Juan", "Perez"));
    }

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

    public void guardarAdministradores(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(coleccionAdministrador);
        }
    }

    public void cargarAdministradores(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Administrador> administradores = (List<Administrador>) ois.readObject();
            coleccionAdministrador.clear();
            coleccionAdministrador.addAll(administradores);
        }
    }



}
