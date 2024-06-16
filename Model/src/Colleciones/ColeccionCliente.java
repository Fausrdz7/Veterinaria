package Colleciones;

import Entidades.Cliente;

import java.util.TreeSet;

public class ColeccionCliente {
    TreeSet<Cliente> miTreeSet = new TreeSet<>();
    private Coleccion< Cliente, TreeSet<Cliente>, String, String > colleccionCliente = new Coleccion<>(miTreeSet);

}