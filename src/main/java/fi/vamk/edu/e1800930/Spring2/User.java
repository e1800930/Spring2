package fi.vamk.edu.e1800930.Spring2;

import java.io.Serializable;
import javax.persistence.*;

//import java.sql.*;
//import javax.persistence.*;
//import lombok.Data;


//to enable you to create a compatible datbase table:
//CREATE TABLE IF NOT EXISTS `User` (`id` int(11) NOT NULL,`name` varchar(10) DEFAULT NULL) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
//ALTER TABLE `User` ADD PRIMARY KEY (`id`);
//ALTER TABLE `partner` MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
//INSERT INTO `partner` (`id`, `name`) VALUES (1, 'VAMK Oy'), (2, 'Timo');
/**
 * The persistent class for the partner database table.
 * 
 */
//@Data
@Entity //(name = "fi.vamk.edu.e1800930.Spring2.User")
//@Table(name = "user")
@NamedQuery(name="User.findAll", query="SELECT p FROM User p")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "\"id\"", nullable = false)
	private int phone;
	@Column(name = "\"phone\"", nullable = true)
	private String email;
	@Column(name = "\"email\"", nullable = false)
	private String name;
	@Column(name = "\"name\"", nullable = false)
	@OneToMany
	@JoinColumn(name="profiles_Id", nullable = false)
	private Profile profiles;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId( int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName( String name) {
		this.name = name;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}

	public Profile getProfile(){
		return this.profiles;
	}
	public void setProfileId(Profile profiles){
		this.profiles = profiles;
	}

	
}