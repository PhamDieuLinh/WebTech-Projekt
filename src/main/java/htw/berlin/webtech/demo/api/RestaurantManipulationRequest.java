package htw.berlin.webtech.demo.api;

import htw.berlin.webtech.persistence.Kategorie;

public class RestaurantManipulationRequest {

    private String name;
    private String address;
    private String description;

    private Kategorie kategorie;

    public RestaurantManipulationRequest(String name, String address, String description, Kategorie kategorie) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.kategorie = kategorie;
    }

    public RestaurantManipulationRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }
}
