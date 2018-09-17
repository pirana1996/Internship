package mk.finki.emt.phoneshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;

@Entity
@Table(name="device")
public class Device extends BaseEntity{

    private String name;

    @Column(length=5000)
    private String description;
    private String photoUrl;
    private Boolean isPromoted;

    private Double price;

    @JsonIgnore
    @Lob
    private byte[] photoData;

    @ManyToOne(fetch = FetchType.EAGER)
    private Manufacturer manufacturer;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Boolean getPromoted() {
        return isPromoted;
    }

    public void setPromoted(Boolean promoted) {
        isPromoted = promoted;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getPhotoData() {
        return photoData;
    }

    public void setPhotoData(byte[] photoData) {
        this.photoData = photoData;
    }

    @Override
    public String toString() {
        return name;
    }
}
