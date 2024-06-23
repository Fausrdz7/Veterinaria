package Colleciones;

import Entidades.Cliente;
import Entidades.Mascota;
import Entidades.Turno;

import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ColeccionTurno {
    private final Coleccion<Turno,String,Mascota> coleccionTurno = new Coleccion<>();
    public Turno buscarTurno(String idTurno){
        try {
            return coleccionTurno.buscar(idTurno);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;        }
    }

    public boolean agregarTurno(Turno turno) {
        return coleccionTurno.agregar(turno);
    }

    public List<Turno> filtrarTurno(Mascota mascota) {
        return coleccionTurno.filtrar(mascota);
    }

    public boolean eliminarTurno(String idTurno) throws Exception {
        Turno turno = buscarTurno(idTurno);
        return coleccionTurno.eliminar(turno);
    }

    public void guardarTurnos(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(coleccionTurno);
        }
    }

    public void cargarTurnos(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            TreeSet<Turno> turnos = (TreeSet<Turno>) ois.readObject();
            coleccionTurno.clear();
            coleccionTurno.addAll(turnos);
        }
    }
}

