package htw.berlin.webtech.demo.api;

public class Restaurant {

    private long rid;
    private String name;
    private String address;
    private String description;

    public Restaurant(long rid, String name, String address, String description) {
        this.rid = rid;
        this.name = name;
        this.address = address;
        this.description = description;
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
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
