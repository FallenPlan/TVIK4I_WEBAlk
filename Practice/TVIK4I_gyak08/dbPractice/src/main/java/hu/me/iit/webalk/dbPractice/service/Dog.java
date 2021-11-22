package hu.me.iit.webalk.dbPractice.service;

public class Dog {
    private Long id;
    private int age;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog() {
    }

    public Dog(Long id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Dog(hu.me.iit.webalk.dbPractice.repository.Dog dog) {
        this.id = dog.getId();
        this.age = dog.getAge();
        this.name = dog.getName();
    }

    public hu.me.iit.webalk.dbPractice.repository.Dog toEntity() {
        return new hu.me.iit.webalk.dbPractice.repository.Dog(id, age, name);
    }
}
