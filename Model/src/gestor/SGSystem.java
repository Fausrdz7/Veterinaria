package gestor;

import Colleciones.ColeccionCliente;
import Colleciones.ColeccionMascota;
import Colleciones.ColeccionVeterinario;
import Colleciones.ColeccionMascota;
import Entidades.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SGSystem {
    private static SGSystem gestor;

    private static JFrame appFrame;

    private final ColeccionCliente  coleccionCliente = new ColeccionCliente();
    private final ColeccionMascota coleccionMascota = new ColeccionMascota();
    private final ColeccionVeterinario coleccionVeterinario = new ColeccionVeterinario();

    private static Cliente clienteSeleccionado;
    private static Veterinario veterinarioSeleccionado;

    public static SGSystem getGestor() {
        if (gestor == null){
            gestor = new SGSystem();
        }
        return gestor;
    }

    public static JFrame getAppFrame() {
        return appFrame;
    }

    public static void setAppFrame(JFrame appFrame) {
        SGSystem.appFrame = appFrame;
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

        if(result == null){
            try{
                veterinarioSeleccionado = coleccionVeterinario.buscarVeterinario(dni);
                System.out.println(veterinarioSeleccionado.toString());
                result = (Usuario) veterinarioSeleccionado;
            }catch ( Exception e ){
                return null;
            }
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

    public List<Mascota> getMascotasByClient(String dni ){
        try {
            return coleccionCliente.buscarCliente(dni).listarMascotas();
        } catch (Exception e) {
            return null;
        }
    }

}
