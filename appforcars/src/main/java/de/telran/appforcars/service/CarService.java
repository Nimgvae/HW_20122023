package de.telran.appforcars.service;

import de.telran.appforcars.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CarService {
    Car getById(Integer id);
    void save(Car car);
    void deleteById(Integer id);
    void update(Integer id, Car car);
    Page<Car> getAllCars(Pageable pageable);


}
