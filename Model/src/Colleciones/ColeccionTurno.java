package Colleciones;

import Entidades.Cliente;
import Entidades.Mascota;
import Entidades.Turno;
import Exepciones.ElementoNoEncontradoException;

import java.util.List;

public class ColeccionTurno {
    private final Coleccion<Turno,String,Mascota> coleccionTurno = new Coleccion<>();
    public Turno buscarTurno(String idTurno){
        try {
            return coleccionTurno.encontrar(idTurno);
        } catch (ElementoNoEncontradoException e) {
            System.out.println(e.getMessage());
            return null;        }
    }

    public boolean agregarTurno(Turno turno) {
        return coleccionTurno.agregar(turno);
    }

    public List<Turno> filtrarTurno(Mascota mascota) {
        return coleccionTurno.filtrar(mascota);
    }


    public boolean eliminarTurno(String idTurno) throws ElementoNoEncontradoException {
        Turno turno = buscarTurno(idTurno);
        if (turno!=null){
        return coleccionTurno.eliminar(turno);}
        else {
            throw new ElementoNoEncontradoException("No se encontro este turno");
        }

    }
    public void DiagnosticarTurno(String matriculaTurno,String observaciones){
        Turno turno = buscarTurno(matriculaTurno);
        turno.setObservaciones(observaciones);
    }
    public boolean finalizarTurno(String matriculaTurno){
        Turno turno=buscarTurno(matriculaTurno);
        return turno.setComlpetado(true);
    }


}

