package hu.iit.me.webalk.db.service;

import hu.iit.me.webalk.db.repository.People;
import hu.iit.me.webalk.db.service.PeopleService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import hu.iit.me.webalk.db.repository.PeopleRepository;

@Service
public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public Iterable<People> getAllPeople() {
        List<People> rv = new ArrayList<>();

        for (People people: peopleRepository.findAll()) {
            rv.add(new People(people));
        }

        return rv;
    }

    @Override
    public hu.iit.me.webalk.db.service.People create(hu.iit.me.webalk.db.service.People people) {
    return new hu.iit.me.webalk.db.service.People(peopleRepository.save(people.toEntity()));
        peopleRepository.save(people.toEntity());

        return null;
    }

    public Iterable<People> getAllPeople2() {
        return StreamSupport.stream(peopleRepository.findAll().spliterator(), false)
                .map(People::new)
                .collect(Collectors.toList());
    }

}
