package Exepciones;

public class ElementoNoEncontradoException extends Exception{
    public ElementoNoEncontradoException(String dato) {
        super("Elemento no encontrado"+dato);
    }
}
