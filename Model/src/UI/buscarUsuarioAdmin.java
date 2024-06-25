package UI;

import gestor.SGSystem;

import javax.swing.*;

public class buscarUsuarioAdmin {
    private JPanel panel;
    private SGSystem gestor = SGSystem.getGestor();


    private JTabbedPane tabbedPane1;
    private JTextField NewObservacion;
    private JTextField NewHoraInicio;
    private JTextField newHoraFinalizacion;
    private JButton confirmarCambiosButton;
    private JTextField InpuCodigoTurno;
    private JButton botonBuscarReserva;
    private JLabel observacionesMascota;
    private JLabel NombreMascota;
    private JLabel HoraDeInicio;
    private JLabel HoraDeFinalizacion;

    public  buscarUsuarioAdmin(){

        botonBuscarReserva.addActionListener( e ->{
            System.out.println("Esto es un boton.");
        } );

    }

    public JPanel getPanel(){
        return panel;
    }



}
