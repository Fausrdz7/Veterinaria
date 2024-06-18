package Colleciones;

import Entidades.Cliente;
import Entidades.Mascota;
import Entidades.Turno;

import java.util.List;

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
}

