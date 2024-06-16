mport java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Coleccion<T extends Filtrable<I> & Buscable<B>, F extends Set<T>, B, I> {

    private final F colection;

    public Coleccion(F colection) {
        this.colection = colection;
    }

    public boolean agregar(T obj) {
        return colection.add(obj);
    }

    public T buscar(B data) throws Exception {
        return colection.stream()
                .filter(obj -> obj.buscar(data))
                .findFirst()
                .orElseThrow(() -> new Exception(String.format("No se pudo encontrar: %s", data)));
    }

    public List<T> filtrar(I data) {
        return colection.stream()
                .filter(obj -> obj.filtrar( data ))
                .collect(Collectors.toList());
    }

    public boolean eliminar(T obj) {
        return colection.remove(obj);
    }

    public List<T> listar() {
        return new ArrayList<>(colection);
    }

}