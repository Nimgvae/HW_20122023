package de.telran.appforcars.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//добавляем аннотацию, чтобы все добавилось(сеттеры,геттеры,конструктор)
@Data
@Entity//ставим ее для того чтобы пошла работа с ОРМ
@Table(name = "car") //Ставим имя таблицы из БД
public class Car {
    //Описываем КАЖДОЕ ПОЛЕ!ЧТобы связать КАЖДОЕ ПОЛЕ с Таблицей
    @Id //Выставялем ПрималКлюч   (выбираем jakarta)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
}
