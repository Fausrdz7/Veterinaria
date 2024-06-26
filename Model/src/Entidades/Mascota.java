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

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", dueno=" + dueno +
                ", dniCliente='" + dniCliente + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", diagnostico=" + diagnostico +
                ", sexo=" + sexo +
                ", diagnosticos=" + diagnosticos +
                '}';
    }

    public Mascota(String nombre, boolean sexo, Date fechaNacimiento, String dniCliente) {
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.dniCliente = dniCliente;
        this.nombre = nombre;
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



    public Cliente getDueno() {
        return dueno;
    }

    public void setDueno(Cliente dueno) {
        this.dueno = dueno;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public ArrayList<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(ArrayList<Diagnostico> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }
}
