package UI;

import Entidades.Cliente;
import Entidades.Mascota;
import Entidades.Usuario;
import gestor.SGSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaCliente {

    private JPanel panel;
    private JLabel userData;
    private JPanel listaMascotas;
    private JPanel crearClientePanel;
    private JButton crearMascotaButton;
    private SGSystem gestor = SGSystem.getGestor();
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private Cliente cliente;
    private List<Mascota> mascotas;

    public VistaCliente(JPanel mainPanel, CardLayout cardLayout, Usuario user) {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;

        cliente = gestor.getClienteByUser(user);
        userData.setText(String.format("Bienvenido %s -  DNI: %s", cliente.getNombre(), cliente.getDni()));

        mascotas = gestor.getMascotasByClient(user.getDni());

        crearClientePanel.setLayout(new GridLayout());
        crearClientePanel.add( new VistaTurno().getPanel() );

        listarMascotas();

        crearMascotaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearMascota dialog = new CrearMascota( SGSystem.getAppFrame() );
                dialog.setVisible(true);
            }
        });
    }

    public void listarMascotas() {
        listaMascotas.removeAll(); // Limpiar el panel antes de agregar nuevas mascotas

        if (!mascotas.isEmpty()) {
            listaMascotas.setLayout(new GridLayout(mascotas.size(), 2, 10, 10)); // Filas: mascotas.size(), Columnas: 2
            for (Mascota mascota : mascotas) {
                System.out.printf("Nombre mascota: %s\n", mascota.getNombre());
                JLabel nombreLabel = new JLabel(mascota.getNombre());
                JButton reservarTurnoButton = new JButton("Reservar turno");
                JButton editarMascotaButton = new JButton("Editar Mascota");

                reservarTurnoButton.addActionListener(e -> {
                    System.out.println("Turno solicitado para " + mascota.getNombre());
                });

                editarMascotaButton.addActionListener( e -> {
                    CrearMascota dialog = new CrearMascota( SGSystem.getAppFrame(), mascota );
                    dialog.setVisible(true);
                } );

                listaMascotas.add(nombreLabel);
                listaMascotas.add(reservarTurnoButton);
                listaMascotas.add(editarMascotaButton);
            }
        } else {
            listaMascotas.add(new JLabel("No hay mascotas que mostrar"));
        }

        listaMascotas.revalidate(); // Actualizar el panel
        listaMascotas.repaint();   // Repintar el panel
    }



    public JPanel getPanel() {
        return panel;
    }
}
