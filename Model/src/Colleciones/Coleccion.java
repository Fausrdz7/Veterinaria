package Colleciones;

import Interfaces.Buscable;
import Interfaces.Filtrable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Coleccion<T extends Filtrable<I> & Buscable<B>, B, I> {

    private final TreeSet<T> elementos=new TreeSet<>();

    public boolean agregar(T obj) {
        return this.elementos.add(obj);
    }

    public T buscar(B data) throws Exception {
        return elementos.stream()
                .filter(obj -> obj.buscar(data))
                .findFirst()
                .orElseThrow(() -> new Exception(String.format("No se pudo encontrar: %s", data)));
    }

    public List<T> filtrar(I data) {
        return elementos.stream()
                .filter(obj -> obj.filtrar( data ))
                .collect(Collectors.toList());
    }

    public boolean eliminar(T obj) {
        return elementos.remove(obj);
    }

    public List<T> listar() {
        return new ArrayList<>(elementos);
    }

}