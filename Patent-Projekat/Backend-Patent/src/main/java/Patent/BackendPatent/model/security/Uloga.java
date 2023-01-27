package Patent.BackendPatent.model.security;

import org.springframework.security.core.GrantedAuthority;

public class Uloga implements GrantedAuthority {

    private String naziv;

    public Uloga() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Uloga(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String getAuthority() {
        return this.naziv;
    }
}
