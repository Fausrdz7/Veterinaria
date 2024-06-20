package Entidades;

import Interfaces.Buscable;
import Interfaces.Filtrable;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;

public class Turno implements Filtrable<Mascota>, Buscable<String>{
    private String observaciones;
    private  final String idTurno;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static int cont = 0;

    private Veterinario veterinario;
    private Mascota mascota;

    private Date horaInic;
    private  Date horaFinal;
    private boolean comlpetado; ///true fue completado && false no fue completada

    public Turno(String observaciones, Veterinario veterinario, Mascota mascota, Date horaInic, Date horaFinal, String idTurno) {
        this.observaciones = null;//porque seran dadas por el veterinario despues del turno
        this.veterinario = veterinario;
        this.mascota = mascota;
        this.horaInic = horaInic;
        this.horaFinal = horaFinal;
        this.comlpetado = false;
        this.idTurno= generarIdturno();

    }
    private String generarIdturno() {
        if (mascota != null) {
            return "R"  +mascota.getDueno().getDni() ;
        } else {
            return "";
        }
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

    public Mascota getMascota() {
        return mascota;
    }
    public String nombreMascota (Mascota mascota){
        String name= getMascota().getNombre();
return name;
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

    public Date getHoraInic() {
        return horaInic;
    }

    public String getHorarioSalidaFormateado() {
        return horaInic.format(formatter);
    }

    public String getHorarioLlegadaFormateado() {
        return horaFinal.format(formatter);
    }
}
