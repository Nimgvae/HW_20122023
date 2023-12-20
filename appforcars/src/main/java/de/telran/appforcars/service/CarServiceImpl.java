package de.telran.appforcars.service;
/*
Сепрвис вызывает репозиторий
*/
import de.telran.appforcars.entity.Car;
import de.telran.appforcars.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;
    @Override
    public Car getById(Integer id) {

        Optional<Car> optional = carRepository.findById(id); //возвращается всегда ОПТИОНАЛ.
        if (optional.isPresent()){
            return optional.get();
        }else {return null;}
    }

    @Override
    public void save(Car car) {
        if(car == null){
            return;
        }else {carRepository.save(car);}

    }

    @Override
    public void deleteById(Integer id) {
        carRepository.deleteById(id);

    }

    @Override
    public void update(Integer id, Car car) {
        Optional<Car> persistCarOptiomnal = carRepository.findById(id); //находим машину и помещаем в коробочку(Оптионал)
        if (persistCarOptiomnal.isPresent()){// тут проверяем не пуста ли коробка
            Car persistCar = persistCarOptiomnal.get(); //Тут мы в объект Car кладем старую машину
            persistCar.setName(car.getName());//тут мы меняем меняем нашему объекту ИМЯ, которое мы берем из аргумента car
            carRepository.save(persistCar);//Тут мы просто сохраняем наш объект через Репозитори назад в БД.
        }
    }
    @Override
    public Page<Car>  getAllCars(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

}
