package UI;

import Entidades.Turno;
import gestor.SGSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaTurno {
    private JPanel panel;
    private SGSystem gestor = SGSystem.getGestor();


    private JTabbedPane tabbedPane1;
    private JTextField NewObservacion;
    private JTextField NewHoraInicio;
    private JButton confirmarCambiosButton;
    private JTextField InpuCodigoTurno;
    private JButton botonBuscarReserva;
    private JLabel observacionesMascota;
    private JLabel NombreMascota;
    private JLabel HoraDeInicio;
    private JLabel HoraDeFinalizacion;
    private JPanel listaTurnos;
    private List<Turno> turnos;


    public VistaTurno(){

        turnos = null; //Obtiene lso turnos del cliente

        listarTurnos();

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

    public void listarTurnos() {
        listaTurnos.removeAll(); // Limpiar el panel antes de agregar nuevas mascotas
        listaTurnos.setLayout(new GridLayout(1, 2, 10, 10)); // Filas: mascotas.size(), Columnas: 2

        if ( turnos != null && !turnos.isEmpty()) {
            listaTurnos.setLayout(new GridLayout(turnos.size(), 2, 10, 10)); // Filas: mascotas.size(), Columnas: 2
            for (Turno turno : turnos) {
                System.out.printf(": %s - Mascota: %s\n", turno.getMascota().getNombre());
                JLabel nombreLabel = new JLabel(String.format( ": %s - Mascota: %s\n", turno.getMascota().getNombre() ));

                JButton cancelarTurnoBtn = new JButton("Canelar Turno");

                cancelarTurnoBtn.addActionListener(e -> {
                    System.out.println("Turno cancelado para " + turno.getIdTurno());
                });

                listaTurnos.add(nombreLabel);
                listaTurnos.add(cancelarTurnoBtn);
            }
        } else {
            listaTurnos.add(new JLabel("No hay turnos que mostrar"));
        }

        listaTurnos.revalidate(); // Actualizar el panel
        listaTurnos.repaint();   // Repintar el panel
    }



    public JPanel getPanel(){
        return panel;
    }



}
