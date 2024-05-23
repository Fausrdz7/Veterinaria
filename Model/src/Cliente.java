import java.util.List;

public class Cliente extends Usuario {
    private List <Mascota>mascotas;

    public Cliente(String nombreUsuario, String contraseña, String dni, Rol role, String nombre, String apellido, List<Mascota> mascotas) {
        super(nombreUsuario, contraseña, dni, role, nombre, apellido);
        this.mascotas = mascotas;
    }
}
