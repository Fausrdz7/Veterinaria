package UI;

import Entidades.Usuario;
import Entidades.Veterinario;
import gestor.VetGestor;

import javax.swing.*;
import java.awt.*;

public class VistaVeterinario {
    private JPanel panel;
    private JLabel userData;
    private JButton cambiarVistaButton;
    private JPanel listaTurnos;
    private JTabbedPane tabbedPane1;
    private JTextField InpuCodigoTurno;
    private JButton botonBuscarReserva;
    private JTextField DiagnosticoTextField;
    private JButton confirmarDiagnosticoYDarButton;
    private VetGestor gestor = VetGestor.getGestor();
    private static Veterinario veterinario;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public VistaVeterinario(JPanel mainPanel, CardLayout cardLayout, Usuario user ){
        veterinario = gestor.getVeterinarioByUser(user);

        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;

    }


    public JPanel getPanel() {
        return panel;
    }

}
