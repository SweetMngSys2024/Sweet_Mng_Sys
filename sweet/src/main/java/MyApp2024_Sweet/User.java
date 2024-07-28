package MyApp2024_Sweet;

public class User {

	String username;
    String password;
    String role;
    
    
	public User(String username2, String password2,String role2) {
		username=username2;
		password=password2;
		role=role2;
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
        return "User [username=" + username + ", password=" + password + ", role=" + role + "]";
    
	}
     
     
     
}
