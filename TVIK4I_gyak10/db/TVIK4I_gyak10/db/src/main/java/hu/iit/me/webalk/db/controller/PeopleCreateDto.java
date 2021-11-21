package hu.iit.me.webalk.db.controller;

import hu.iit.me.webalk.db.service.People;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class PeopleCreateDto {

    public PeopleCreateDto() {
    }

    public PeopleCreateDto(People people) {
        this.age = people.getAge();
        this.name = people.getName();
    }

    @NotEmpty
    private String name;
    @Min(18)
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

    public People toPeople() {
        return new People(age, null, name);
    }
}


