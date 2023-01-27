package Patent.BackendPatent.dto;

public class KorisnikDTO {
    private String email;
    private  String lozinka;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public KorisnikDTO() {
    }

    public KorisnikDTO(String email, String lozinka) {
        this.email = email;
        this.lozinka = lozinka;
    }
}
