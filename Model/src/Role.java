public enum Role {
    ADMIN ("Admin"),
    CLIENTE ("Cliente"),
    VETERINARIO ("Veterinario");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
