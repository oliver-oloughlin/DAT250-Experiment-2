package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;
    @ManyToMany(mappedBy = "addresses")
    private Set<Person> owners;

    public String getStreet() {
        return this.street;
    }

    public Integer getNumber() {
        return this.number;
    }

    public Collection<Person> getOwners() {
        return this.owners;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setOwners(Set<Person> owners) {
        this.owners = owners;
    }
}
