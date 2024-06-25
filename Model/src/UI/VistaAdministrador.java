package UI;

import gestor.SGSystem;

import javax.swing.*;

public class VistaAdministrador {
    private SGSystem gestor = SGSystem.getGestor();

    private JTextField observaciones;
    private JTextField mascota;
    private JTextField horaDeInicio;
    private JTextField HoraDeFinalizacion;
    private JButton confirmarCambiosButton;
    private JTabbedPane tabbedPane1;

    public VistaAdministrador(SGSystem gestor, JTextField observaciones, JTextField mascota, JTextField horaDeInicio, JTextField horaDeFinalizacion, JButton confirmarCambiosButton, JTabbedPane tabbedPane1) {
        this.gestor = gestor;
        this.observaciones = observaciones;
        this.mascota = mascota;
        this.horaDeInicio = horaDeInicio;
        HoraDeFinalizacion = horaDeFinalizacion;
        this.confirmarCambiosButton = confirmarCambiosButton;
        this.tabbedPane1 = tabbedPane1;
    }

}

