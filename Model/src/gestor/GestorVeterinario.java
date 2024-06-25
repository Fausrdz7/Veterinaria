package gestor;

import Colleciones.ColeccionCliente;
import Entidades.Cliente;
import Entidades.Usuario;

public class GestorVeterinario {
    private static GestorVeterinario gestor;

    private final ColeccionCliente  coleccionCliente = new ColeccionCliente();

    private static Cliente clienteSeleccionado;

    public static GestorVeterinario getGestor() {
        if (gestor == null){
            gestor = new GestorVeterinario();
        }
        return gestor;
    }

    public Usuario iniciarSesion(String dni, String password ){
        System.out.printf(" User: %s \nPass: %s\n", dni, password);
        Cliente result = null;

        try {
            result =  coleccionCliente.buscarCliente( dni );
            clienteSeleccionado = result;
        }catch ( Exception e ){
            return null;
        }

        if ( result == null || !result.getContraseña().equals(password) ){
            return null;
        }

        return (Usuario) result;
    }



    public Cliente getCliente() {
        return clienteSeleccionado;
    }


    public Cliente getClienteByUser(Usuario user) {
        try {
            return coleccionCliente.buscarCliente(user.getDni() );
        } catch (Exception e) {
            return null;
        }
    }
}
