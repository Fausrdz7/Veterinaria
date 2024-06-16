import Entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {
    private List<Usuario> usuariosList;

    public GestorUsuarios() {
        usuariosList = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuariosList.add(usuario);
    }
    public void eliminarUsuario(Usuario usuario) {
        usuariosList.remove(usuario);
    }

    public Usuario buscarUsuario(String dni) {
        for (Usuario usuario : usuariosList) {
            if(usuario.getDni().equals(dni)) {
                return usuario;
            }
        }
        return null;
    }
}


