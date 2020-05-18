package rest.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name = "CLIENTSS")
@Table(name = "CLIENTSS")
public class EClient implements Serializable
{
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "user_id")
    private String user_id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "second_name")
	private String second_name;
	
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
	
	public String getUserId() {
        return user_id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }	
	
	public String getSecondName() {
        return second_name;
    }

    public void setSecondName(String second_name) {
        this.second_name = second_name;
    }
}
