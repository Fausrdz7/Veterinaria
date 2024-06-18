package Entidades;

import Entidades.Diagnostico;
import Interfaces.Buscable;
import Interfaces.Filtrable;

import java.util.Date;

public class Mascota implements Filtrable<String>, Buscable<String> {
    private String nombre;
    private Cliente dueno;
    private Date fechaNacimiento;
    private Diagnostico diagnostico;
    private boolean sexo;/// true= masculino && false == femenino


    @Override
    public boolean buscar(String criterio) {
        return false;
    }

    @Override
    public boolean filtrar(String criterio) {
        return false;
    }
}
