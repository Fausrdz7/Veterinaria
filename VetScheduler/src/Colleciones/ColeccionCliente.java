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

        Cliente c1 = new Cliente( "1234", "333333", Rol.CLIENTE, "AA", "BB");
        c1.agregarMascota( new Mascota("COCO", true,  new Date(), c1.getDni()) );
        c1.agregarMascota( new Mascota("VICKY", false,  new Date(), c1.getDni()) );

        coleccionCliente.agregar(c1);

        coleccionCliente.agregar( new Cliente( "1234", "444444" , Rol.CLIENTE , "BB", "CC"));

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