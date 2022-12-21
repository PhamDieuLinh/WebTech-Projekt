package htw.berlin.webtech.demo.api;

public class RestaurantManipulationRequest {

    private String name;
    private String address;
    private String description;

    public RestaurantManipulationRequest(String name, String address, String description) {
        this.name = name;
        this.address = address;
        this.description = description;
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
}
