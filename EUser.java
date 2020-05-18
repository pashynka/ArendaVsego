package rest.model.entity;

import java.io.Serializable;

import javax.persistence.*;


@Entity(name = "USERSS")
@Table(name = "USERSS")
public class EUser implements Serializable
{
	@Id
	//@SequenceGenerator(name = "TEST_USERS_SEQ", sequenceName = "TEST_USERS_SEQ", allocationSize = 1, initialValue = 1 )
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_USERS_SEQ")
	@Column(name = "id")
	private String id;
	
	@Column(name = "login")
    private String login;
	
	@Column(name = "pass")
	private String pass;
	
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }	
	
	public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
