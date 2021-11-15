package hu.iit.me.webalk.db.service;


import hu.iit.me.webalk.db.repository.People;

public interface PeopleService {
    Iterable<People> getAllPeople();
}
