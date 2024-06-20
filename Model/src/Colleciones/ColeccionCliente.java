package Colleciones;

import Entidades.Cliente;
import Entidades.Turno;
import Exepciones.ElementoNoEncontradoException;

import java.util.List;

public class    ColeccionCliente {
    private final Coleccion< Cliente,  String, String > coleccionCliente = new Coleccion<>();

    public void agregar(Cliente cliente){
        coleccionCliente.agregar(cliente);
    }
    public boolean agregarCliente(Cliente vuelo) {
        return coleccionCliente.agregar(vuelo);
    }

    public Cliente buscarCliente(String dni) {
        try {
            return coleccionCliente.encontrar(dni);
        } catch (ElementoNoEncontradoException e) {
            System.out.println(e.getMessage());
            return null;        }
    }

    public List<Cliente> filtrarCLientes(String dni) {
        return coleccionCliente.filtrar(dni);
    }

    public boolean eliminarCliente(String dni) throws Exception {
        Cliente vuelo = buscarCliente(dni);
        return coleccionCliente.eliminar(vuelo);
    }

}