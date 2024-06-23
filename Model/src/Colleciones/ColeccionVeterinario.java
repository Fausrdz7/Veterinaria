package Colleciones;

import Entidades.Turno;
import Entidades.Veterinario;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

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

    public void guardarVeterinarios(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(coleccionVeterinario);
        }
    }

    public void cargarVeterinarios(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            TreeSet<Veterinario> veterinarios = (TreeSet<Veterinario>) ois.readObject();
            coleccionVeterinario.clear();
            coleccionVeterinario.addAll(veterinarios);
        }
    }
}
