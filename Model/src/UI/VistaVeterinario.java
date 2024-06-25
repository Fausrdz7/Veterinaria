package UI;

import Entidades.Usuario;
import Entidades.Veterinario;
import gestor.SGSystem;

import javax.swing.*;
import java.awt.*;

public class VistaVeterinario {
    private JPanel panel;
    private JLabel userData;
    private JButton cambiarVistaButton;
    private JPanel listaTurnos;
    private SGSystem gestor = SGSystem.getGestor();
    private static Veterinario veterinario;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public VistaVeterinario(JPanel mainPanel, CardLayout cardLayout, Usuario user ){
        veterinario = gestor.getVeterinarioByUser(user);
        userData.setText( veterinario.toString() );
        userData.setText( String.format(  "Bienvenido %s -  DNI: %s", veterinario.getNombre(), veterinario.getDni()  ) );

        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;


        cambiarVistaButton.addActionListener( e -> {
            cambiarAVistaNueva();
        } );

    }

    public void cambiarAVistaNueva(){
        mainPanel.add( new vistaNUeva().getPanel(), "vistaNueva" );
        cardLayout.show( mainPanel, "vistaNueva" );
    }

    public JPanel getPanel() {
        return panel;
    }

}
