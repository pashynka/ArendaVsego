package rest.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name = "ADSS")
@Table(name = "ADSS")
public class EAd implements Serializable
{
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "client_id")
    private String client_id;
	
	@Column(name = "category_id")
	private String category_id;
	
	@Column(name = "heading")
	private String heading;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "publication_date")
	private String publication_date;
	
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public String getClientId() {
        return client_id;
    }

    public void setClientId(String client_id) {
        this.client_id = client_id;
    }
	
	public String getCategoryId() {
        return category_id;
    }

    public void setCategoryId(String category_id) {
        this.category_id = category_id;
    }
	
	public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
	
	public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
	
	public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
	
	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
	
	public String getPublicationDate() {
        return publication_date;
    }

    public void setPublicationDate(String publication_date) {
        this.publication_date = publication_date;
    }
    
}
