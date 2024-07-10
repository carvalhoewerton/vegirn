package veg.vegi.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "pl4ces")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String tripAdvisor;
    private double x;
    private double y;
    private String img;
    private String address;
    private double distance;

    public Place() {}

    public Place(Long id, String name, String description, String tripAdvisor, double x, double y, String img, String address) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tripAdvisor = tripAdvisor;
        this.x = x;
        this.y = y;
        this.img = img;
        setAddress(address);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getTripAdvisor() {
        return tripAdvisor;
    }

    public void setTripAdvisor(String tripAdvisor) {
        this.tripAdvisor = tripAdvisor;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setAddress(String adress){
        this.address = adress;
    }

    public String getAddress(){
        return this.address;
    }

}
