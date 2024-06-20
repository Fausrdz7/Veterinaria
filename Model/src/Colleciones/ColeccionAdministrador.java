package Colleciones;

import Entidades.Administrador;
import Entidades.Cliente;
import Entidades.Turno;
import Exepciones.ElementoNoEncontradoException;

import java.util.List;

public class ColeccionAdministrador {
    private final Coleccion<Administrador,String,String>coleccionAdministrador = new Coleccion<>();

    public boolean agregarAdministrador(Administrador administrador) {
        return coleccionAdministrador.agregar(administrador);
    }


    public Administrador buscaraAdmin(String dni){
        try {
            return coleccionAdministrador.encontrar(dni);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Administrador> filtrarAdministrador(String dni) {
        return coleccionAdministrador.filtrar(dni);
    }

    public boolean eliminarAdministrador(String dni)  {
        try {
            Administrador administrador = buscaraAdmin(dni);
       return coleccionAdministrador.eliminar(administrador);}
        catch (Exception e){
            System.out.println("no se encontro este administrador");
            return false;
        }
    }


}
