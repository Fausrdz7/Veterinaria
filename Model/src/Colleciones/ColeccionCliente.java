package Colleciones;

import Entidades.Cliente;
import Entidades.Mascota;
import Enumeraciones.Rol;

import java.util.List;

public class ColeccionCliente {
    private final Coleccion< Cliente,  String, String > coleccionCliente = new Coleccion<>();

    public ColeccionCliente(){

        coleccionCliente.agregar( new Cliente( "ccliente", "1234", "333333" , Rol.CLIENTE , "AA", "BB", null ) );
        coleccionCliente.agregar( new Cliente( "acliente", "1234", "444444" , Rol.CLIENTE , "BB", "CC", null ) );

    }

    public void agregar(Cliente cliente){
        coleccionCliente.agregar(cliente);
    }

    public boolean agregarCliente(Cliente vuelo) {
        return coleccionCliente.agregar(vuelo);
    }

    public Cliente buscarCliente(String dni) throws Exception {
        return coleccionCliente.buscar(dni);
    }

    public List<Cliente> filtrarCLientes(String dni) {
        return coleccionCliente.filtrar(dni);
    }

    public boolean eliminarCliente(String dni) throws Exception {
        Cliente vuelo = buscarCliente(dni);
        return coleccionCliente.eliminar(vuelo);
    }

}