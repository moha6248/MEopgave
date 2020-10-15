package com.example.demo.Repository;

import com.example.demo.Model.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICarRepository extends CrudRepository<Car,Integer> {


}
