import UI.CrearCliente;
import UI.LogIn;
import UI.VistaCliente;
import UI.buscarUsuarioAdmin;

import javax.swing.*;
import java.awt.*;

public class Main {

    private  static JFrame frame;
    private static CardLayout cardLayout ;
    private static JPanel mainPanel;


    public static void main(String[] args) {
        init();
    }

    public static void init(){

        frame = new JFrame("Gestion Veterinaria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        //mainPanel.add( new LogIn( mainPanel, cardLayout ).getPanel() , "login");
        mainPanel.add( new buscarUsuarioAdmin().getPanel() );

        frame.add( mainPanel );

        cardLayout.show( mainPanel, "login" );

        frame.pack();
        frame.setVisible(true);

    }


}