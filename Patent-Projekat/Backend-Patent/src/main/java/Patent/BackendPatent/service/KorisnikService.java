package Patent.BackendPatent.service;

import Patent.BackendPatent.model.RegisterUser;
import Patent.BackendPatent.model.security.Korisnik;
import Patent.BackendPatent.model.security.Uloga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

@Service
public class KorisnikService implements UserDetailsService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // ako se ne radi nasledjivanje, paziti gde sve treba da se proveri email
        List<Uloga>lista = new ArrayList<>();

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //ResponseEntity<RegisterUser>responseEntity =restTemplate.getForEntity("http://localhost:9090/register/user/{username}", RegisterUser.class,email);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/xml");
        //headers.set("Other-Header", "othervalue");

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<?> responseEntity = restTemplate.exchange(
                "http://localhost:9090/register/user/"+email, HttpMethod.GET, requestEntity, Object.class);
        LinkedHashMap<String,String> registerUser = (LinkedHashMap<String,String>)responseEntity.getBody();
        assert registerUser != null;
        lista.add(new Uloga(registerUser.get("role")));
        Korisnik user = new Korisnik(registerUser.get("username"),registerUser.get("password"),lista);
        UserDetails userDetails;

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
        } else {
            return  user;
        }
    }
}
