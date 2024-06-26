package Colleciones;

import Entidades.Turno;
import Entidades.Veterinario;
import Entidades.Mascota;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ColeccionTurno {
    private final ArrayList<Turno> coleccionTurno = new ArrayList<>();

    // Método para buscar un turno por ID
    public Turno buscarTurno(String idTurno){
        for (Turno turno : coleccionTurno) {
            if (turno.getIdTurno().equals(idTurno)) {
                return turno;
            }
        }
        System.out.println("Turno no encontrado");
        return null;
    }

    // Método para agregar un turno
    public boolean agregarTurno(Turno turno) {
        return coleccionTurno.add(turno);
    }

    // Método para filtrar turnos por mascota
    public List<Turno> filtrarTurno(Mascota mascota) {
        List<Turno> turnosFiltrados = new ArrayList<>();
        for (Turno turno : coleccionTurno) {
            if (turno.getMascota().equals(mascota)) {
                turnosFiltrados.add(turno);
            }
        }
        return turnosFiltrados;
    }

    // Método para eliminar un turno por ID
    public boolean eliminarTurno(String idTurno) throws Exception {
        Turno turno = buscarTurno(idTurno);
        if (turno != null) {
            return coleccionTurno.remove(turno);
        }
        throw new Exception("Turno no encontrado");
    }

    public void guardarTurnos(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(coleccionTurno);
        }
    }

    public void cargarTurnos(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Turno> turnos = (List<Turno>) ois.readObject();
            coleccionTurno.clear();
            coleccionTurno.addAll(turnos);
        }
    }

    // Método para crear y agregar un turno si no hay superposición de horarios
    public void crearYAgregarTurno(String observaciones, Veterinario veterinario, Mascota mascota, Date horaInicio, Date horaFinalizacion) {
        for (Turno turno : coleccionTurno) {
            if (turno.getVeterinario().equals(veterinario) &&
                    ((horaInicio.before(turno.getHoraFinal()) && horaInicio.after(turno.getHoraInic())) ||
                            (horaFinalizacion.before(turno.getHoraFinal()) && horaFinalizacion.after(turno.getHoraInic())) ||
                            (horaInicio.before(turno.getHoraInic()) && horaFinalizacion.after(turno.getHoraFinal())) ||
                            (horaInicio.equals(turno.getHoraInic()) || horaFinalizacion.equals(turno.getHoraFinal())))) {
                // Superposición de horarios
                System.out.println("Error: El horario del turno se superpone con otro turno existente.");
                return;
            }
        }

        // Si no hay superposición, creamos y agregamos el turno
        Turno nuevoTurno = new Turno(observaciones, veterinario, mascota, horaInicio, horaFinalizacion);
        coleccionTurno.add(nuevoTurno);
        System.out.println("Turno agregado exitosamente.");
    }

    public List<Turno> obtenerTurnos() {
        return new ArrayList<>(coleccionTurno);
    }

}
