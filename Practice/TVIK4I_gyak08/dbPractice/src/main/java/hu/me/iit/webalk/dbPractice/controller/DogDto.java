package hu.me.iit.webalk.dbPractice.controller;

import hu.me.iit.webalk.dbPractice.service.Dog;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class DogDto {
    public DogDto() {
    }

    public DogDto(Dog dog) {
        this.id = dog.getId();
        this.age = dog.getAge();
        this.name = dog.getName();
    }
    private Long id;
    @NotEmpty
    private String name;
    @Min(2)
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return new Dog(id, age, name);
    }
}
