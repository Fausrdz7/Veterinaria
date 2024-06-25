package Entidades;

import Entidades.Diagnostico;
import Interfaces.Buscable;
import Interfaces.Filtrable;

import java.util.ArrayList;
import java.util.Date;

public class Mascota implements Filtrable<String>, Buscable<String> {
    private String nombre;
    private Cliente dueno;
    private Date fechaNacimiento;
    private Diagnostico diagnostico;
    private boolean sexo;/// true= masculino && false == femenino

    private ArrayList<Diagnostico> diagnosticos;

    @Override
    public boolean buscar(String dni) {
        return dni.equals( dueno.getDni() );
    }

    @Override
    public boolean filtrar(String dni) {
        return dni.equals( dueno.getDni() );
    }
}
