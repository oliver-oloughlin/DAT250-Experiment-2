package no.hvl.dat250.jpa.assignment2.driver;

import no.hvl.dat250.jpa.assignment2.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "experiment2";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // TODO: Persist object world corresponding to the domain model of experiment 2.
        Pincode pin = new Pincode();
        pin.setPincode("123");
        pin.setCount(1);

        CreditCard c1 = new CreditCard();
        c1.setNumber(123);
        c1.setBalance(1);
        c1.setLimit(2_000);

        CreditCard c2 = new CreditCard();
        c2.setNumber(12345);
        c2.setBalance(-5_000);
        c2.setLimit(-10_000);

        Person p = new Person();
        p.setName("Max Mustermann");

        Address a = new Address();
        a.setStreet("Inndalsveien");
        a.setNumber(28);

        Bank b = new Bank();
        b.setName("Pengebank");

        Set<CreditCard> cards = new HashSet();
        cards.add(c1);
        cards.add(c2);

        Set<Address> addresses = new HashSet();
        addresses.add(a);

        Set<Person> people = new HashSet();
        people.add(p);

        p.setAddresses(addresses);
        a.setOwners(people);
        p.setCreditCards(cards);
        b.setOwnedCards(cards);
        c1.setOwningBank(b);
        c1.setPincode(pin);
        c2.setOwningBank(b);
        c2.setPincode(pin);

        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(pin);
        em.persist(p);
        em.persist(a);
        em.persist(b);
        em.persist(c1);
        em.persist(c2);
        t.commit();
    }
}
