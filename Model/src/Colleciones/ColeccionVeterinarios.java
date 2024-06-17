package Colleciones;

import Entidades.Veterinario;
import Exepciones.ElementoNoEncontradoException;

public class ColeccionVeterinarios {
    private final Coleccion<Veterinario,String,String>coleccionVeterinario=new Coleccion<>();

    public Veterinario buscarVeterinario(String matricula)  {
        try {
            return coleccionVeterinario.buscar(matricula);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;        }
    }
    public boolean agregar (Veterinario veterinario){
       return coleccionVeterinario.agregar(veterinario);
    }

    public boolean finalizarTurno(){
        return this.turno.setComlpetado(true);
    }

}
