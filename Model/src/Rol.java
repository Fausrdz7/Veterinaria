public enum Rol {
    ADMIN ("Admin"),
    CLIENTE ("Cliente"),
    VETERINARIO ("Veterinario");

    private final String role;

    Rol(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
