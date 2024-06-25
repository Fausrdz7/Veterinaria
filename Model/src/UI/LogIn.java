package UI;

import Entidades.Usuario;
import gestor.SGSystem;

import javax.swing.*;
import java.awt.*;

public class LogIn {
    private final static String newline = "\n";

    private SGSystem gestor = SGSystem.getGestor();
    private JPanel panel;
    private JTextField dniInput;
    private JButton logInButton;
    private JPanel login;
    private JPasswordField passwordInput;
    private JPanel mainPanel;
    private CardLayout cardLayout;



    public LogIn(JPanel mainPanel, CardLayout cardLayout) {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;


        logInButton.addActionListener( e -> {
            if ( dniInput.getText().length() > 3 && new String( passwordInput.getPassword() ).length() > 3  ){

                Usuario nUser = gestor.iniciarSesion(dniInput.getText(), new String( passwordInput.getPassword() ) );

                if (nUser == null){
                    JOptionPane.showMessageDialog( null, "Usuario y/o contraseña incorrectos." );
                }else {

                    mainPanel.add( new VistaCliente( mainPanel, cardLayout, nUser ).getPanel(), "vistaCliente" );
                    cardLayout.show( mainPanel, "vistaCliente" );
                }

            }else {
                JOptionPane.showMessageDialog( null, "Usuario y contraseña invalidos." );
            }
            // cardLayout.show( mainPanel, "cliente" );
        } );

    }


    public JPanel getPanel(){
        return panel;
        //Comteario
    }


}
