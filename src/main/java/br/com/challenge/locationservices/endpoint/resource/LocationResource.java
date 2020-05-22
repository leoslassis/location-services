package br.com.challenge.locationservices.endpoint.resource;

public class LocationResource {

    private Long id;
    private String street;
    private String district;
    private String city;
    private String state;
    private String postalCode;

    public LocationResource() {
    }

    public LocationResource(Long id, String street, String district, String city, String state, String postalCode) {
        this.id = id;
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
