package detalleTurnos;

import Entidades.Turno;

import javax.swing.*;

public class DetalleTurno extends JDialog{
    private final Turno turno;
    private JPanel contentPane;
    private JButton botonReservar;
    private JLabel mascota;

    private JLabel horarioSalida;
    private JLabel horarioLlegada;
    private JComboBox<EstadoVuelo> comboEstadoVuelo;

    public DetalleTurno(Turno turno) {
        this.turno = turno;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(botonReservar);

        mascota.setText(this.turno.nombreMascota(this.turno.getMascota()));
        horarioSalida.setText(this.turno.getHorarioSalidaFormateado());
        horarioLlegada.setText(this.turno.getHorarioLlegadaFormateado());
        comboEstadoVuelo.setSelectedItem();

        botonReservar.addActionListener(e -> {
            DialogReservaVuelo dialogReservaVuelo = new DialogReservaVuelo(this.vuelo);
            dialogReservaVuelo.setVisible(true);
        });
    }

}
