package hu.me.iit.firstSpring;

import javax.validation.constraints.NotNull;

public class Article {
    @NotNull
    private Long id;

    @NotNull
    private String author;

    @NotNull
    private Integer age;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
