package in.daypay.poc.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "poc_user")
@NamedQueries({
	@NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :userId"),
	@NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "username", columnDefinition = "user unique name to identify", nullable = false)
	private String username;
	
	@Column(name = "email", columnDefinition = "user email", nullable = false)
	private String email;
	
	@Column(name = "password", columnDefinition = "user password", nullable = false)
	private String password;
	
	@Column(name = "first_name", columnDefinition = "user first name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", columnDefinition = "user last name", nullable = true)
	private String lastName;
	
	// required default constructor
	public User() {
		
	}
	
	public User(String firstName, String username, String password) {
		this.firstName = firstName;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
