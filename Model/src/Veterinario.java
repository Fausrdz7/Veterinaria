public class Veterinario extends Usuario{
    private String matricula;

    public Veterinario(String nombreUsuario, String contraseña, String dni, Role role, String nombre, String apellido, String matricula) {
        super(nombreUsuario, contraseña, dni, role, nombre, apellido);
        this.matricula = matricula;
    }
}
