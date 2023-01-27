package Patent.BackendPatent.security.auth.model;

import java.io.Serializable;

public class AuthResponse implements Serializable {
    private String username;
    private String token;

    public AuthResponse() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AuthResponse(String username, String token) {
        this.username = username;
        this.token = token;
    }
}
