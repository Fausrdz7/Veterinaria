package Colleciones;

import Entidades.Turno;
import Entidades.Veterinario;
import Enumeraciones.Rol;

import java.util.Arrays;

public class ColeccionVeterinario {
    private final Coleccion<Veterinario,String,String>coleccionVeterinario=new Coleccion<>();

    public ColeccionVeterinario() {
        coleccionVeterinario.agregar( new Veterinario("vete1","1234","222222", Rol.VETERINARIO,"Pablo","Estravis","AAA111",null));
    }

    public Veterinario buscarVeterinario(String dni)  {
        try {
            return coleccionVeterinario.buscar(dni);
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
