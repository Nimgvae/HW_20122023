package de.telran.appforcars.controller;
/*
Создаем входную точку в приложении.Контролер вызывает сервис
* */
import de.telran.appforcars.entity.Car;
import de.telran.appforcars.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @GetMapping(value = "/car/{id}")
    public Car getCarbyId(@PathVariable(value = "id")Integer id){
        //Контроллер всегда обращается к слою СЕРВИСА.
        Car car = carService.getById(id);
        return car;
    }
    @PostMapping(value = "/car")
    public void saveCar(@RequestBody Car car) {
    }
    @DeleteMapping(value = "/car/{id}")
    public void deleteById(@PathVariable(value = "id")Integer id){
        carService.deleteById(id);
    }
    @PutMapping(value = "/car/{id}")
    public void updateCarById(@PathVariable(value = "id")Integer id,@RequestBody Car car){
        carService.update(id,car);
    }
    @GetMapping(value = "/car/all")
    public Page<Car> getAllCars(Pageable pageable) {
        return carService.getAllCars(pageable);
    }

}
