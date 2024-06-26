package UI;

import Entidades.Usuario;
import Enumeraciones.Rol;
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

    private VistaCliente vistaCliente;



    public LogIn(JPanel mainPanel, CardLayout cardLayout) {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;


        logInButton.addActionListener( e -> {
            if ( dniInput.getText().length() > 3 && new String( passwordInput.getPassword() ).length() > 3  ){

                Usuario nUser = gestor.iniciarSesion(dniInput.getText(), new String( passwordInput.getPassword() ) );

                if (nUser == null){
                    JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos.");
                } else {
                    if(nUser.getRole().equals(Rol.CLIENTE)){
                        SGSystem.setVistaCliente(new VistaCliente(mainPanel, cardLayout, nUser));
                        mainPanel.add(SGSystem.getVistaCliente().getPanel(), "vistaCliente");
                        cardLayout.show(mainPanel, "vistaCliente");
                    } else if (nUser.getRole().equals(Rol.VETERINARIO)) {
                        mainPanel.add(new VistaVeterinario(mainPanel, cardLayout, nUser).getPanel(), "vistaVeterinario");
                        cardLayout.show(mainPanel, "vistaVeterinario");
                    } 
//                    else if (nUser.getRole().equals(Rol.ADMIN)) {
//                        mainPanel.add(new VistaAdministrador(mainPanel, cardLayout, nUser).getPanel(), "vistaAdministrador");
//                        cardLayout.show(mainPanel, "vistaAdministrador");
//                    }
                }
            }else {
                JOptionPane.showMessageDialog( null, "Usuario y contraseña invalidos." );
            }
            // cardLayout.show( mainPanel, "cliente" );
        } );


    }


    public JPanel getPanel(){
        return panel;
    }


}
