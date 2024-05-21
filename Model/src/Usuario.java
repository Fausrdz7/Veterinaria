public abstract class   Usuario  {
    private String nombreUsuario;
    private String contraseña;
    private  String dni;
    private Role role;
    private String nombre;
    private  String apellido;


    public Usuario(String nombreUsuario, String contraseña, String dni, Role role, String nombre, String apellido) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.dni = dni;
        this.role = role;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}

