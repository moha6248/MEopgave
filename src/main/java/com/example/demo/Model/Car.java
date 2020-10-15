package com.example.demo.Model;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;

    private String carBrand;
    private String carModel;
    private String carYear;

  //  @ManyToMany
   // List<Person>personset;

  //  @OneToMany(mappedBy = "car")
  //  List<Car> cars;

  /*  @ManyToMany(mappedBy = "persons")
    private Set<Car>cars ;


    public Set<Car> getCars() {
        return cars;
    }*/

    public Car(){
    }

    public Car(int carId, String carBrand, String carModel, String carYear) {
        this.carId = carId;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carYear = carYear;

    }



    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carYear='" + carYear + '\'' +
                '}';
    }
}
