package UI;

import Entidades.Cliente;
import Entidades.Usuario;
import gestor.GestorVeterinario;

import javax.swing.*;

public class VistaCliente {

    private JPanel panel;
    private JLabel userData;
    private GestorVeterinario gestor = GestorVeterinario.getGestor();
    private static Cliente cliente;

    public VistaCliente(){
        cliente = gestor.getCliente();
    }

    public VistaCliente( Usuario user ){
           cliente = gestor.getClienteByUser( user );
            userData.setText( cliente.toString() );
    }

    public JPanel getPanel() {
        return panel;
    }


    public void setCliente(Cliente nCliente){
        cliente = nCliente;
        userData.setText( nCliente.toString() );
    }

}
