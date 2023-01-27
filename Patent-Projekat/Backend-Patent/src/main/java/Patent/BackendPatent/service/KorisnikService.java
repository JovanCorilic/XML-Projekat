package Patent.BackendPatent.service;

import Patent.BackendPatent.model.security.Korisnik;
import Patent.BackendPatent.model.security.Uloga;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KorisnikService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // ako se ne radi nasledjivanje, paziti gde sve treba da se proveri email
        List<Uloga>lista = new ArrayList<>();
        lista.add(new Uloga("Sluzbenik"));
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        Korisnik user = new Korisnik("1",bCryptPasswordEncoder.encode("1"),lista);
        UserDetails userDetails;

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
        } else {
            return  user;
        }
    }
}
