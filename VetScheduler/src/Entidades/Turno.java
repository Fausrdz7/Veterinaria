package Entidades;

import Interfaces.Buscable;
import Interfaces.Filtrable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Turno implements Filtrable<Mascota>, Buscable<String>{
    private String observaciones;
    private  final String idTurno;
    private Veterinario veterinario;
    private Mascota mascota;
    private Date horaInic;
    private  Date horaFinal;
    private boolean comlpetado; ///true fue completado && false no fue completada

    public Turno(String observaciones, Veterinario veterinario, Mascota mascota, Date horaInic, Date horaFinal) {
        this.observaciones = observaciones;
        this.veterinario = veterinario;
        this.mascota = mascota;
        this.horaInic = horaInic;
        this.horaFinal = horaFinal;
        this.comlpetado = false;
        this.idTurno = String.format( "%s-%s", veterinario.getApellido(), mascota.getNombre() ) ;

    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean setComlpetado(boolean comlpetado) {
       return this.comlpetado = comlpetado;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "observaciones='" + observaciones + '\'' +
                ", veterinario=" + veterinario +
                ", mascota=" + mascota +
                ", horaInic=" + horaInic +
                ", horaFinal=" + horaFinal +
                ", comlpetado=" + comlpetado +
                '}';
    }

    @Override
    public boolean buscar(String criterio) {
        return this.idTurno.contains(criterio);
    }



    @Override
    public boolean filtrar(Mascota criterio) {
        return this.mascota.equals(criterio);
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getIdTurno() {
        return idTurno;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Date getHoraInic() {
        return horaInic;
    }

    public void setHoraInic(Date horaInic) {
        this.horaInic = horaInic;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public boolean isComlpetado() {
        return comlpetado;
    }
}
