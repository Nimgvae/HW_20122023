package de.telran.appforcars.repository;
import de.telran.appforcars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//По сути одна строка, с двумя дженериками(Ентити и ПрималКлюч)
/*
JPARepository Это интерфейс, в котором описаны базовые методы.Он наследуется от других Репозиториев и каждый из  них описывает большое количество методов.
ОДнако, где же реализация всех этих методов?!SimpleJpaRepository является ответственным за то, чтобы все реализации работали!
Поэтому НАШИ репозитории будут пустыми, ну или почти пустыми, так как все уже реализовано и мы можем использовать как нам надо
*/
@Repository //Указываем что это за зверь
public interface CarRepository extends JpaRepository<Car, Integer> {
    Page<Car> findAll(Pageable pageable);
}
