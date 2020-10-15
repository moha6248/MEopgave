package com.example.demo.Repository;

import com.example.demo.Model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class CarRepository implements ICarRepository{

    @Autowired

    JdbcTemplate jdbc;
    private ICarRepository carRepository;
    private List<Car> cars;
    private SqlRowSet rs;

    public CarRepository(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public <S extends Car> S save(S cars) {

        String sql ="INSERT INTO Car(CAR_ID,CAR_BRAND,CAR_MODEL,CAR_YEAR)  VALUES(?,?,?,?)";
        jdbc.update(sql,
                cars.getCarId(),cars.getCarBrand(),cars.getCarModel(),cars.getCarYear()
        );

        return null;
    }

    @Override
    public <S extends Car> Iterable<S> saveAll(Iterable<S> iterable) {



            return null;
        }



    @Override
    public Optional<Car> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Car> findAll() {
          //  cars.clear();

        List<Car>carList = new ArrayList<>();
            rs = jdbc.queryForRowSet("SELECT * FROM car");
            while (rs.next()){
                carList.add(new Car(rs.getInt("CAR_ID"),
                        rs.getString("CAR_BRAND"),
                        rs.getString("CAR_MODEL"),
                        rs.getString("CAR_YEAR")));

            }
            return carList;

    }

    @Override
    public Iterable<Car> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Car car) {

    }

    @Override
    public void deleteAll(Iterable<? extends Car> iterable) {

    }

    @Override
    public void deleteAll() {

    }




    /*
    @Autowired
    private JdbcTemplate jdbc;
    private List<Car> cars;
    private SqlRowSet rs;



    @Override
    public void create(Car car) {

    }

    @Override
    public List<Car> readAll() {
        cars.clear();
        rs = jdbc.queryForRowSet("SELECT * FROM cars");
        while (rs.next()){
            cars.add(new Car(rs.getInt("carId"),
            rs.getString("carBrand"),
            rs.getString("carModel"),
            rs.getString("carYear")));

        }
        return cars;
    }*/
}
