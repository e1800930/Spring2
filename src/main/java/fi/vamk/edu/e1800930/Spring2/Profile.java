package fi.vamk.edu.e1800930.Spring2;

import java.io.Serializable;
import java.util.Set;

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
@Entity //(name = "fi.vamk.edu.e1800930.Spring2.Profile")
//@Table(name = "profile")
@NamedQuery(name="Profile.findAll", query="SELECT p FROM User p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
    private String name;
    @OneToMany(mappedBy = "profiles")
    private Set<User> users;

	public Profile() {
	}

    public int getId(){
        return this.Id ;
    }
    public void setId(int Id){
        this.Id = Id;
    }

    public String getName(){
        return this.name ;
    }



	
}