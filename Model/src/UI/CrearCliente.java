package UI;

import gestor.SGSystem;

import javax.swing.*;

public class CrearCliente {
    private SGSystem gestor = SGSystem.getGestor();

    private JPanel panel;
    private JTextField nombreInput;
    private JTextField apellidoInput;
    private JButton crearButton;


    public CrearCliente() {
        crearButton.addActionListener( e ->{
            System.out.printf( "nombre: %s \n", nombreInput.getText() );
        } );
    }

    public JPanel getPanel() {
        return panel;
    }

}
