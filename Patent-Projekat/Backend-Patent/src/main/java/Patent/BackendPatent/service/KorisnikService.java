package Patent.BackendPatent.service;

import Patent.BackendPatent.model.RegisterUser;
import Patent.BackendPatent.model.security.Korisnik;
import Patent.BackendPatent.model.security.Uloga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class KorisnikService implements UserDetailsService {
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // ako se ne radi nasledjivanje, paziti gde sve treba da se proveri email
        List<Uloga>lista = new ArrayList<>();

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        ResponseEntity<RegisterUser>responseEntity =restTemplate.getForEntity("http://localhost:9090/user/"+email, RegisterUser.class);

        lista.add(new Uloga(Objects.requireNonNull(responseEntity.getBody()).getRole()));
        Korisnik user = new Korisnik(responseEntity.getBody().getUsername(),bCryptPasswordEncoder.encode(responseEntity.getBody().getPassword()),lista);
        UserDetails userDetails;

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
        } else {
            return  user;
        }
    }
}
