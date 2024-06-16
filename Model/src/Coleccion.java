import java.util.List;
import java.util.TreeSet;

public class Coleccion < T extends Filtrable<T> & Buscable<T> , F > {

    private final F<E> colection = new TreeSet<E>();

    public boolean agregar(E obj) {
        return colection.add(obj);
    }

    public E buscar(C data) throws ElementoNoEncontradoException {
        return colection.stream().filter(obj -> obj.coincideCon(data) ).findFirst()
                .orElseThrow( ()-> new Exception( String.format("No se pudo encontrar: %s ", data)));
    }

    public List<E> filtrar(F data) {
        return colection.stream().filter(obj -> obj.cumpleFiltro(data)).toList();
    }

    public boolean eliminar( E obj ){
        return colection.remove( obj );
    }

    public List<E> listar() {
        return colection.stream().toList();
    }

}