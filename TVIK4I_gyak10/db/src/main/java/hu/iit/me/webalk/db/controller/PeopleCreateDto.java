package hu.iit.me.webalk.db.controller;

import hu.iit.me.webalk.db.repository.People;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PeopleCreateDto {

    public PeopleCreateDto() {
    }

    public PeopleCreateDto(People people) {
        this.age = people.getAge();
        this.name = people.getName();
    }
    private Long id;
    @NotEmpty
    private String name;
    @Size(min=18)
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

    public People toPeople() {
        return new People(age, null, name);
    }
}


