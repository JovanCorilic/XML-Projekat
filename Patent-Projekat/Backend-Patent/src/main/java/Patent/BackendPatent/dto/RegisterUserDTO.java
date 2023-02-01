package Patent.BackendPatent.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class RegisterUserDTO {
	
//	@XmlElement(name = "username")
	private String username;

//	@XmlElement(name = "password")
	private String password;

//	@XmlElement(name = "role")
	private String role;

	public RegisterUserDTO(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public RegisterUserDTO() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RegisterUser [username=" + username + ", password=" + password + ", role=" + role + "]";
	}

}
