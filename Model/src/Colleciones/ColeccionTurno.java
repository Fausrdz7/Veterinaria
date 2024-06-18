package Colleciones;

import Entidades.Mascota;
import Entidades.Turno;

public class ColeccionTurno {
    private final Coleccion<Turno,Mascota,String> coleccionturno = new Coleccion<>();
    public Turno buscarTurno(String idTurno){
        try {
            return coleccionturno.buscar(idTurno);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;        }
    }
}

