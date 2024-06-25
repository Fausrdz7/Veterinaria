package UI;

import Entidades.Cliente;
import Entidades.Mascota;
import Entidades.Usuario;
import gestor.SGSystem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VistaCliente {

    private JPanel panel;
    private JLabel userData;
    private JPanel listaMascotas;
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
        listarMascotas();
    }

    public void listarMascotas() {
        listaMascotas.removeAll(); // Limpiar el panel antes de agregar nuevas mascotas

        if (!mascotas.isEmpty()) {
            listaMascotas.setLayout(new GridLayout(mascotas.size(), 2, 10, 10)); // Filas: mascotas.size(), Columnas: 2
            for (Mascota mascota : mascotas) {
                System.out.printf("Nombre mascota: %s\n", mascota.getNombre());
                JLabel nombreLabel = new JLabel(mascota.getNombre());
                JButton reservarTurnoButton = new JButton("Reservar turno");

                reservarTurnoButton.addActionListener(e -> {
                    System.out.println("Turno solicitado para " + mascota.getNombre());
                });

                listaMascotas.add(nombreLabel);
                listaMascotas.add(reservarTurnoButton);
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
