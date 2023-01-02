package htw.berlin.webtech.demo.api;

import htw.berlin.webtech.persistence.Kategorie;

import java.util.List;

public class Restaurant {

    private long rid;
    private String name;
    private String address;
    private String description;

    private Kategorie kategorie;
    private List<Long> bewertungIds;

    public Restaurant(long rid, String name, String address, String description, Kategorie kategorie, List<Long> bewertungIds) {
        this.rid = rid;
        this.name = name;
        this.address = address;
        this.description = description;
        this.kategorie = kategorie;
        this.bewertungIds = bewertungIds;
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

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    public List<Long> getBewertungIds() {
        return bewertungIds;
    }

    public void setBewertungIds(List<Long> bewertungIds) {
        this.bewertungIds = bewertungIds;
    }
}
