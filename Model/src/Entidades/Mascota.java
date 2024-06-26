package Entidades;

import Entidades.Diagnostico;
import Interfaces.Buscable;
import Interfaces.Filtrable;

import java.util.ArrayList;
import java.util.Date;

public class Mascota implements Filtrable<String>, Buscable<String> {
    private String nombre;
    private Cliente dueno;
    private String dniCliente;
    private Date fechaNacimiento;
    private Diagnostico diagnostico;
    private boolean sexo;/// true= masculino && false == femenino

    public Mascota( String nombre, boolean sexo, Date fechaNacimiento, String dniCliente) {
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.dniCliente = dniCliente;
        this.nombre = nombre;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    private ArrayList<Diagnostico> diagnosticos;

    @Override
    public boolean buscar(String dni) {
        return dni.equals( dueno.getDni() );
    }

    @Override
    public boolean filtrar(String dni) {
        return dni.equals( dueno.getDni() );
    }

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
