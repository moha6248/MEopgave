package com.example.demo.Controller;

import com.example.demo.Model.Car;
import com.example.demo.Repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    ICarRepository carRepository;

    public CarController(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public String index(Model model){
        return "index";
    }

    @GetMapping("/overview")
    public String overview(Model model){
      model.addAttribute("carOverview",carRepository.findAll());
        return "overview";
    }

    //Create a Car request
    @GetMapping("/create-car")
    public String createCar(Model model)
    {
        Car cars = new Car();
        model.addAttribute("newCar", cars);
        return "create";
    }
    //Allows input request about creating a car
    @PostMapping("/create-car")
    public String createdCar(@ModelAttribute Car newCar)
    {
        //Adds the created car to the database
      carRepository.save(newCar);

        return "overview";
    }

}
