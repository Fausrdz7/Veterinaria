package gestor;

import Colleciones.*;
import Colleciones.ColeccionMascota;
import Colleciones.ColeccionVeterinario;
import Entidades.*;
import Enumeraciones.Rol;
import UI.VistaCliente;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VetGestor {
    private static VetGestor gestor;

    private static JFrame appFrame;
    private static VistaCliente vistaCliente;

    private final ColeccionCliente  coleccionCliente = new ColeccionCliente();
    private final ColeccionMascota coleccionMascota = new ColeccionMascota();
    private final ColeccionVeterinario coleccionVeterinario = new ColeccionVeterinario();
    private final ColeccionTurno coleccionTurno = new ColeccionTurno();
    private final ColeccionAdministrador coleccionAdministrador = new ColeccionAdministrador();

    private static Cliente clienteSeleccionado;
    private static Veterinario veterinarioSeleccionado;

    public static VetGestor getGestor() {
        if (gestor == null){
            gestor = new VetGestor();


            Cliente c1 = new Cliente( "1234", "333333", Rol.CLIENTE, "AA", "BB");
            c1.agregarMascota( new Mascota("COCO", true,  new Date(), c1.getDni()) );
            c1.agregarMascota( new Mascota("VICKY", false,  new Date(), c1.getDni()) );

            gestor.coleccionCliente.agregar(c1);

            gestor.coleccionCliente.agregar( new Cliente( "1234", "444444" , Rol.CLIENTE , "BB", "CC"));

            gestor.coleccionVeterinario.agregarVeterinario( new Veterinario("1234","222222", Rol.VETERINARIO,"Pablo","Estravis","AAA111"));
        }
        return gestor;
    }

    public static JFrame getAppFrame() {
        return appFrame;
    }

    public static void setAppFrame(JFrame appFrame) {
        VetGestor.appFrame = appFrame;
    }

    public static VistaCliente getVistaCliente() {
        return vistaCliente;
    }

    public static void setVistaCliente(VistaCliente vistaCliente) {
        VetGestor.vistaCliente = vistaCliente;
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
            //e.printStackTrace();
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
    public Administrador getAdminByUser(Usuario user) {
        try {
            return coleccionAdministrador.buscarAdministrador(user.getDni());
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
//            if (turno.getMascota().getDniCliente().equals(cliente.getDni()) && !turno.getHoraInic().before(fechaActual)) {
//                turnosCliente.add(turno);
//            }
        }
        return turnosCliente;
    }

    public Turno crearTurno(String dniCli, String dniVet, Mascota mascota, Date horaInicio, Date horaFinalizacion) {
        try {
            Cliente cliente = coleccionCliente.buscarCliente(dniCli);
            Veterinario veterinario = coleccionVeterinario.buscarVeterinario(dniVet);

            if (cliente == null || veterinario == null) {
                System.out.println("Cliente o veterinario no encontrado");
                return null;
            }


            Turno nuevoTurno = new Turno(null, veterinario, mascota, horaInicio, horaFinalizacion);

            return nuevoTurno;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void agregarTurnosMascota(Mascota mascota,List<Turno> turnos) {

        for (Turno turno : turnos){
            if (mascota.equals(turno.getMascota())) {
                turnosMascota(turno);
            }
        }
    }

    public List<Turno>turnosMascota(Turno turno){
        List<Turno>turnos=new ArrayList<>();
        turnos.add(turno);
        return turnos;
    }

    public void completarTurno(String idTurno, String observaciones){
        Turno turno = coleccionTurno.buscarTurno(idTurno);
        turno.setComlpetado(true);
        turno.setObservaciones(observaciones);
    }

    public void agregarMascota(Mascota nuevaMascota) {
        getCliente().agregarMascota( nuevaMascota );
    }

    public void borrarMascota(String nombre) {
        getCliente().eliminarMascotaPorNombre(  nombre  );
    }

}
