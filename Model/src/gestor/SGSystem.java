package gestor;

import Colleciones.*;
import Colleciones.ColeccionMascota;
import Entidades.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SGSystem {
    private static SGSystem gestor;

    private final ColeccionCliente  coleccionCliente = new ColeccionCliente();
    private final ColeccionMascota coleccionMascota = new ColeccionMascota();
    private final ColeccionVeterinario coleccionVeterinario = new ColeccionVeterinario();
    private final ColeccionTurno coleccionTurno = new ColeccionTurno();

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

    public List<Turno> listarTurnos(Cliente cliente) {
        List<Turno> turnosCliente = new ArrayList<>();
        Date fechaActual = new Date();
        for (Turno turno : coleccionTurno.obtenerTurnos()) {
            if (turno.getMascota().getDueno().equals(cliente) && !turno.getHoraInic().before(fechaActual)) {
                turnosCliente.add(turno);
            }
        }
        return turnosCliente;
    }
}
