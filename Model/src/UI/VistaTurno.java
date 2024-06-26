package UI;

import gestor.SGSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaTurno {
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
    private JTextField textField1;

    public VistaTurno(){

        botonBuscarReserva.addActionListener( e ->{
            System.out.println("Esto es un boton.");
        } );

        confirmarCambiosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Actualiza un turno, SGSystem.actualizarTurno( Cliente, fecha nueva, mascota )
            }
        });
    }

    public JPanel getPanel(){
        return panel;
    }



}
