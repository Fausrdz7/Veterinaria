package UI;

import gestor.SGSystem;

import javax.swing.*;
import java.awt.*;

public class DiagnosticarVeterinario {
    private JPanel panel;

    private JTextField InpuCodigoTurno;
    private JButton botonBuscarReserva;
    private JTextField DiagnosticoTextField;
    private JButton confirmarDiagnosticoYDarButton;
    private SGSystem gestor = SGSystem.getGestor();


    public DiagnosticarVeterinario(JPanel panel, JPanel mainPanel, CardLayout cardLayout, JTextField inpuCodigoTurno, JButton botonBuscarReserva, JTextField diagnosticoTextField, JButton confirmarDiagnosticoYDarButton) {
        this.panel = panel;
        InpuCodigoTurno = inpuCodigoTurno;
        this.botonBuscarReserva = botonBuscarReserva;
        DiagnosticoTextField = diagnosticoTextField;
        this.confirmarDiagnosticoYDarButton = confirmarDiagnosticoYDarButton;
    }


    public JPanel getPanel() {
        return panel;
    }

}
