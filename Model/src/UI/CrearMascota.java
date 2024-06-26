package UI;

import Entidades.Mascota;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Calendar;

public class CrearMascota extends JDialog {

    private JPanel contentPane;
    private JTextField nombreInput;
    private JSpinner fechaNacimientoSpinner;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel fechaNacimientoPanel;
    private JComboBox sexoInput;
    private JButton borrarButton;

    private boolean mascotaCreada;
    private Mascota nuevaMascota;

    public CrearMascota(JFrame parent) {
        super(parent, "Crear Nueva Mascota", true); // true indica que es modal

        // Inicialización de componentes


        sexoInput.addItem( "MACHO" );
        sexoInput.addItem( "HEMBRA" );

        // Panel para los botones
        JPanel buttonsPanel = new JPanel();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        fechaNacimientoSpinner = new JSpinner(dateModel);
        fechaNacimientoSpinner.setEditor(new JSpinner.DateEditor(fechaNacimientoSpinner, "dd/MM/yyyy"));

        fechaNacimientoPanel.setLayout(new GridLayout());
        fechaNacimientoPanel.add(fechaNacimientoSpinner);


        // Listener para el botón cancelar
        buttonCancel.addActionListener( e->{
                mascotaCreada = false;
                dispose(); // Cierra el diálogo
        });

        // Configuración del diálogo
        add(contentPane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(parent);
    }

    public CrearMascota(JFrame parent, Mascota mascota) {
        super(parent, "Editar Nueva Mascota", true); // true indica que es modal

        nombreInput.setText( mascota.getNombre() );

        borrarButton.setVisible( true );


        sexoInput.addItem( "MACHO" );
        sexoInput.addItem( "HEMBRA" );

        if (mascota.getSexo()){
            sexoInput.setSelectedIndex(0);
        }else {
            sexoInput.setSelectedIndex(1);
        }

        // Panel para los botones
        JPanel buttonsPanel = new JPanel();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        SpinnerDateModel dateModel = new SpinnerDateModel(mascota.getFechaNacimiento(), null, null, Calendar.DAY_OF_MONTH);
        fechaNacimientoSpinner = new JSpinner(dateModel);
        fechaNacimientoSpinner.setEditor(new JSpinner.DateEditor(fechaNacimientoSpinner, "dd/MM/yyyy"));

        fechaNacimientoPanel.setLayout(new GridLayout());
        fechaNacimientoPanel.add(fechaNacimientoSpinner);


        // Listener para el botón cancelar
        buttonCancel.addActionListener( e->{
            mascotaCreada = false;
            dispose(); // Cierra el diálogo
        });

        // Configuración del diálogo
        add(contentPane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(parent);
    }

    private void crearMascota() {
        String nombre = nombreInput.getText().trim();
        Date fechaNacimiento = (Date) fechaNacimientoSpinner.getValue();

        // Validación de datos (puedes agregar validaciones según tus necesidades)
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre de la mascota es requerido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear la instancia de Mascota
        nuevaMascota = new Mascota(nombre, true, fechaNacimiento, ""); // Por defecto el sexo masculino

        //TODO: Hay que agregar la mascota al objeto clienteSeleccionado dentro del Gestor

        // Indicar que la mascota ha sido creada exitosamente
        mascotaCreada = true;

        // Cerrar el diálogo
        dispose();
    }

    private void borrarMascota() {
        //TODO: borra la mascota seleccionada buscandola por nombre
    }

    private void editarMascota() {
        //TODO: Toma los nuevos datos de las mascotas y los actualiza
    }

    public boolean isMascotaCreada() {
        return mascotaCreada;
    }

    public Mascota getNuevaMascota() {
        return nuevaMascota;
    }
}