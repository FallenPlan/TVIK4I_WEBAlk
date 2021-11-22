package hu.me.iit.webalk.dbPractice.controller;

import hu.me.iit.webalk.dbPractice.service.Dog;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class DogCreateDto {

    public DogCreateDto() {
    }

    public DogCreateDto(Dog dog) {
        this.age = dog.getAge();
        this.name = dog.getName();
    }

    @NotEmpty
    private String name;
    @Min(2)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog toDog() {
        return new Dog(null, age, name);
    }
}
