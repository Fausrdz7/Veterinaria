package Colleciones;

import Entidades.Cliente;

import java.util.List;
import java.util.TreeSet;

public class ColeccionCliente {
    private Coleccion< Cliente,  String, String > colleccionCliente = new Coleccion<>();

    public void agregar(Cliente cliente){
        colleccionCliente.agregar(cliente);
    }
    public boolean agregarCliente(Cliente vuelo) {
        return colleccionCliente.agregar(vuelo);
    }

    public Cliente buscarCliente(String codigoVuelo) throws Exception {
        return colleccionCliente.buscar(codigoVuelo);
    }

    public List<Cliente> filtrarCLientes(String dni) {
        return colleccionCliente.filtrar(dni);
    }

    public boolean eliminarCliente(String dni) throws Exception {
        Cliente vuelo = buscarCliente(dni);
        return colleccionCliente.eliminar(vuelo);
    }
}
}