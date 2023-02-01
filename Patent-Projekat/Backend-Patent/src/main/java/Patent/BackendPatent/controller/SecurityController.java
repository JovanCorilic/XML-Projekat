package Patent.BackendPatent.controller;

import Patent.BackendPatent.dto.RegisterUserDTO;
import Patent.BackendPatent.dto.UserTokenStateDTO;
import Patent.BackendPatent.jaxb.JaxbParser;
import Patent.BackendPatent.model.security.Korisnik;
import Patent.BackendPatent.security.auth.service.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBException;
import java.util.Date;

@RestController
@RequestMapping(value = "api/security", produces = MediaType.APPLICATION_XML_VALUE,
        consumes = MediaType.APPLICATION_XML_VALUE)
@CrossOrigin
public class SecurityController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RestTemplate restTemplate;
    private JaxbParser jaxbParser;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @PostMapping("/register")
    public ResponseEntity<Void>register(@RequestBody String xml) throws JAXBException {
        Patent.BackendPatent.dto.KorisnikDTO.Korisnik korisnik = jaxbParser.unmarshall(Patent.BackendPatent.dto.KorisnikDTO.Korisnik.class,xml);
        RegisterUserDTO registerUserDTO = new RegisterUserDTO(korisnik.getKorisnickoIme(),korisnik.getLozinka(),korisnik.getUloga());

        HttpEntity<RegisterUserDTO>httpEntity = new HttpEntity<>(registerUserDTO);
        restTemplate.postForEntity("http://localhost:9090/register",httpEntity,Boolean.class);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/login",produces = MediaType.ALL_VALUE)
    public ResponseEntity<?> login(@RequestBody String xml) throws Exception{
        Patent.BackendPatent.dto.KorisnikDTO.Korisnik korisnik = jaxbParser.unmarshall(Patent.BackendPatent.dto.KorisnikDTO.Korisnik.class,xml);

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(korisnik.getKorisnickoIme(), korisnik.getLozinka()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Korisnik user = (Korisnik) authentication.getPrincipal();
        String jwt = jwtUtil.generateToken(user.getEmail(), user.getUloge().get(0).getNaziv());
        int expiresIn = jwtUtil.getExpiredIn();

        return new ResponseEntity<>(new UserTokenStateDTO(jwt, (long) expiresIn), HttpStatus.OK);
    }
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    //@PreAuthorize("hasAnyRole('Sluzbenik')")
    @GetMapping(value = "/logout",consumes = MediaType.ALL_VALUE,produces = MediaType.ALL_VALUE)
    public ResponseEntity<?>logoutUser()throws Exception{
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Korisnik korisnik = (Korisnik) auth.getPrincipal();
            SecurityContextHolder.clearContext();
        }catch (Exception e){
            SecurityContextHolder.clearContext();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
