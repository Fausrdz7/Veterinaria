package Colleciones;

import Entidades.Turno;
import Entidades.Veterinario;
import Exepciones.ElementoNoEncontradoException;

public class ColeccionVeterinario {
    private final Coleccion<Veterinario,String,String>coleccionVeterinario=new Coleccion<>();

    public Veterinario buscarVeterinario(String matricula)  {
        try {
            return coleccionVeterinario.encontrar(matricula);
        }catch (ElementoNoEncontradoException e) {
            System.out.println(e.getMessage());
            return null;     }
    }
    public boolean agregarVeterinario (Veterinario veterinario){
       return coleccionVeterinario.agregar(veterinario);
    }




}
