import Entidades.Insumo;

import java.util.ArrayList;
import java.util.List;

public class GestorInsumos {
    private List<Insumo> insumosList;

    public GestorInsumos(List<Insumo> insumosList) {
        insumosList = new ArrayList<>();
    }

    public void agregarInsumo(Insumo Insumo) {
        insumosList.add(Insumo);
    }
    public void eliminarUsuario(Insumo Insumo) {
        insumosList.remove(Insumo);
    }

}
