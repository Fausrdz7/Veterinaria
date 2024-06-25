package UI;

import Entidades.Cliente;
import Entidades.Usuario;
import gestor.SGSystem;

import javax.swing.*;
import java.awt.*;

public class VistaCliente {

    private JPanel panel;
    private JLabel userData;
    private JPanel listaMascotas;
    private JButton cambiarVistaButton;
    private SGSystem gestor = SGSystem.getGestor();
    private static Cliente cliente;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public VistaCliente  (){
        cliente = gestor.getCliente();
    }

    public VistaCliente(JPanel mainPanel, CardLayout cardLayout, Usuario user ){
           cliente = gestor.getClienteByUser( user );
            userData.setText( cliente.toString() );
            userData.setText( String.format(  "Bienvenido %s -  DNI: %s", cliente.getNombre(), cliente.getDni()  ) );

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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
