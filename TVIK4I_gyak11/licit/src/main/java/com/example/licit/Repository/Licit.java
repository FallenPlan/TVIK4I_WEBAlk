package com.example.licit.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Licit {

    @Id
    @GeneratedValue
    private Long id;

    private Integer licit;
    private Integer userid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Licit(int licit, int userId) {
        this.licit = licit;
        this.userid = userId;
    }

    public int getLicit() {
        return licit;
    }

    public void setLicit(int licit) {
        this.licit = licit;
    }

    public int getUserId() {
        return userid;
    }

    public void setUserId(int userId) {
        this.userid = userId;
    }
}
