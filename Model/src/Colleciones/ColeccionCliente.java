package Colleciones;

import Entidades.Cliente;

import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class    ColeccionCliente {
    private final Coleccion< Cliente,  String, String > coleccionCliente = new Coleccion<>();

    public void agregar(Cliente cliente){
        coleccionCliente.agregar(cliente);
    }
    public boolean agregarCliente(Cliente vuelo) {
        return coleccionCliente.agregar(vuelo);
    }

    public Cliente buscarCliente(String codigoVuelo) throws Exception {
        return coleccionCliente.buscar(codigoVuelo);
    }

    public List<Cliente> filtrarCLientes(String dni) {
        return coleccionCliente.filtrar(dni);
    }

    public boolean eliminarCliente(String dni) throws Exception {
        Cliente vuelo = buscarCliente(dni);
        return coleccionCliente.eliminar(vuelo);
    }

    public void guardarClientes(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(coleccionCliente);
        }
    }

    public void cargarClientes(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            TreeSet<Cliente> clientes = (TreeSet<Cliente>) ois.readObject();
            coleccionCliente.clear();
            coleccionCliente.addAll(clientes);
        } catch (FileNotFoundException e) {
            System.out.println("El archivo " + fileName + " no se encontró.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); // Manejar excepciones de lectura o deserialización
        }
    }

}