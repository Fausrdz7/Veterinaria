package Colleciones;

import Entidades.Turno;
import Entidades.Veterinario;

public class ColeccionVeterinario {
    private final Coleccion<Veterinario,String,String>coleccionVeterinario=new Coleccion<>();

    public Veterinario buscarVeterinario(String matricula)  {
        try {
            return coleccionVeterinario.buscar(matricula);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;        }
    }
    public boolean agregarVeterinario (Veterinario veterinario){
       return coleccionVeterinario.agregar(veterinario);
    }

//    public void observacionTurno(String matriculaTurno,String observaciones){
//        Turno turno = buscarTurno(matriculaTurno);
//        turno.setObservaciones(observaciones);
//    }
//    public boolean finalizarTurno(String matriculaTurno){
//        Turno turno=buscarTurno(matriculaTurno);
//        return turno.setComlpetado(true);
//    }

}
