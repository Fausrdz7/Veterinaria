package gestor;

import Colleciones.ColeccionCliente;
import Colleciones.ColeccionVeterinario;
import Entidades.Cliente;
import Entidades.Usuario;
import Entidades.Veterinario;

public class SGSystem {
    private static SGSystem gestor;

    private final ColeccionCliente  coleccionCliente = new ColeccionCliente();
    private final ColeccionVeterinario coleccionVeterinario = new ColeccionVeterinario();

    private static Cliente clienteSeleccionado;
    private static Veterinario veterinarioSeleccionado;

    public static SGSystem getGestor() {
        if (gestor == null){
            gestor = new SGSystem();
        }
        return gestor;
    }

    public Usuario iniciarSesion(String dni, String password ){
        System.out.printf(" User: %s \nPass: %s\n", dni, password);
        Usuario result = null;

        try {
            clienteSeleccionado = coleccionCliente.buscarCliente(dni);
            if (clienteSeleccionado != null) {
                result = (Usuario) clienteSeleccionado;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            veterinarioSeleccionado = coleccionVeterinario.buscarVeterinario(dni);
            System.out.println(veterinarioSeleccionado.toString());
            result = (Usuario) veterinarioSeleccionado;
        }catch ( Exception e ){
            return null;
        }

        if ( result == null || !result.getContraseña().equals(password) ){
            return null;
        }
        System.out.println(result.toString());

        return result;
    }



    public Cliente getCliente() {
        return clienteSeleccionado;
    }


    public Cliente getClienteByUser(Usuario user) {
        try {
            return coleccionCliente.buscarCliente(user.getDni());
        } catch (Exception e) {
            return null;
        }
    }
    public Veterinario getVeterinarioByUser(Usuario user) {
        try {
            return coleccionVeterinario.buscarVeterinario(user.getDni());
        } catch (Exception e) {
            return null;
        }
    }
}
