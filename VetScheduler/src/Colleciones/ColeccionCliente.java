package Colleciones;

import Entidades.Cliente;
import Entidades.Mascota;
import Enumeraciones.Rol;

import java.io.*;
import java.util.Date;
import java.util.List;

public class ColeccionCliente {
    private final Coleccion< Cliente,  String, String > coleccionCliente = new Coleccion<>();

    public ColeccionCliente(){
    }

    public void agregar(Cliente cliente){
        coleccionCliente.agregar(cliente);
    }


    public Cliente buscarCliente(String dni) throws Exception {
        return coleccionCliente.buscar(dni);
    }

    public List<Cliente> filtrarCLientes(String dni) {
        return coleccionCliente.filtrar(dni);
    }

    public boolean eliminarCliente(String dni) throws Exception {
        Cliente nCliente = buscarCliente(dni);
        return coleccionCliente.eliminar(nCliente);
    }

    public void guardarClientes(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(coleccionCliente);
        }
    }

    // Método para cargar clientes desde un archivo
    public void cargarClientes(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Cliente> clientes = (List<Cliente>) ois.readObject();
            coleccionCliente.clear();
            coleccionCliente.addAll(clientes);
        }
    }

}