package Colleciones;

import Entidades.Turno;
import Entidades.Veterinario;
import Enumeraciones.Rol;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class ColeccionVeterinario {
    private final Coleccion<Veterinario,String,String>coleccionVeterinario=new Coleccion<>();

    public ColeccionVeterinario() {
        coleccionVeterinario.agregar( new Veterinario("1234","222222", Rol.VETERINARIO,"Pablo","Estravis","AAA111"));
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

    public void guardarVeterinarios(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(coleccionVeterinario);
        }
    }

    public void cargarVeterinarios(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Veterinario> veterinarios = (List<Veterinario>) ois.readObject();
            coleccionVeterinario.clear();
            coleccionVeterinario.addAll(veterinarios);
        }
    }
}
