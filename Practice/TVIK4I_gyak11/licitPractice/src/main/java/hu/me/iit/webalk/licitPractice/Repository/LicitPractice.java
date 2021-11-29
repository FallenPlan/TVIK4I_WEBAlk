package hu.me.iit.webalk.licitPractice.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LicitPractice {
    @Id
    @GeneratedValue
    private Long id;

    private Integer licit;
    private Integer userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LicitPractice(int licit, int userId) {
        this.licit = licit;
        this.userId = userId;
    }

    public int getLicit() {
        return licit;
    }

    public void setLicit(int licit) {
        this.licit = licit;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
