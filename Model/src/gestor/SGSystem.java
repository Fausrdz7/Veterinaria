package gestor;

import Colleciones.ColeccionCliente;
import Colleciones.ColeccionMascota;
import Entidades.Cliente;
import Entidades.Mascota;
import Entidades.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SGSystem {
    private static SGSystem gestor;

    private final ColeccionCliente  coleccionCliente = new ColeccionCliente();
    private final ColeccionMascota coleccionMascota = new ColeccionMascota();

    private static Cliente clienteSeleccionado;

    public static SGSystem getGestor() {
        if (gestor == null){
            gestor = new SGSystem();
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

    public List<Mascota> getMascotasByClient(String dni ){
        try {
            return coleccionCliente.buscarCliente(dni).listarMascotas();
        } catch (Exception e) {
            return null;
        }
    }
}
