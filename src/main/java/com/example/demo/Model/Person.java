package com.example.demo.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    private String Name;

   @OneToMany
    List<Car>cars;
/*
    public Set<Car> getCars() {
        return cars;
    }*/
    @ManyToMany
    List<Car>car;

    public Person(){
    }

    public Person(int personId, String name) {
        this.personId = personId;
        Name = name;

    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
