package UI;

import javax.swing.*;

public class LogIn {
    private final static String newline = "\n";

    private final JFrame frame;
    private JPanel container;
    private JTextField usernameInput;
    private JTextField passwordInput;
    private JButton LOGINButton;

    public static void main(String[] args) {
        System.out.println("Iniciando UI...");

        LogIn logInInstance = new LogIn();

    }

    public  LogIn(){
        frame = new JFrame("Reserva de vuelos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(container);

        frame.pack();
        frame.setVisible(true);
        frame.setSize( 500, 600 );

        usernameInput.addActionListener( e -> {
            String text = usernameInput.getText();

            System.out.printf( "El texto es :  %s\n", text );
        } );

    }


}
