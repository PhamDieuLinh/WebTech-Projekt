package htw.berlin.webtech.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "restaurants")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "description")
    private String description;

    @Column(name = "kategorie")
    @Enumerated(value = EnumType.STRING)
    private Kategorie kategorie;

    @OneToMany(mappedBy = "resid", fetch = FetchType.EAGER)
    private List<BewertungEntity> bewertungen = new ArrayList<>();

    public RestaurantEntity(String name, String address, String description, Kategorie kategorie) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.kategorie = kategorie;
    }

    protected RestaurantEntity(){

    }

    public Long getId() {
        return id;
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

    public List<BewertungEntity> getBewertungen() {
        return bewertungen;
    }

    public void setBewertungen(List<BewertungEntity> bewertungen) {
        this.bewertungen = bewertungen;
    }
}
