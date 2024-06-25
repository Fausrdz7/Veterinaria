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
            System.out.printf( "apellido: %s \n", apellidoInput.getText() );
        } );
    }

    public JPanel getPanel() {
        return panel;
    }

}
