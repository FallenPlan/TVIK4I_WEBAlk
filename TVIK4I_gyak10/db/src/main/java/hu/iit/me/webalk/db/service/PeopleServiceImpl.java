package hu.iit.me.webalk.db.service;

import hu.iit.me.webalk.db.repository.People;
import hu.iit.me.webalk.db.service.PeopleService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import hu.iit.me.webalk.db.repository.PeopleRepository;

@Service
public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public People create(People people) {
        return new People(peopleRepository.save(people.toEntity()));
    }

    @Override
    public People getById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        peopleRepository.delete(id);
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
    public People create(People people) {
        return new People(peopleRepository.save(people.toEntity()));
    }

    @Override
    public void delete(Long id) {
        try {
            peopleRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw NoSuchEntityException();
        }
    }

    @Override
    public hu.iit.me.webalk.db.service.People create(hu.iit.me.webalk.db.service.People people) {
    return new hu.iit.me.webalk.db.service.People(peopleRepository.save(people.toEntity()));
        peopleRepository.save(people.toEntity());

        return null;
    }

    @Override
    public People getById(Long id) {
        Optional<hu.iit.me.webalk.db.repository.People> optionalPeople = peopleRepository.findById();
                if(optionalPeople.isEmpty()) {
                    throw new NoSuchEntityException();
                }
        return new People(optionalPeople.get());
    }

    @Override
    public void save(People people) {
        Optional<hu.iit.me.webalk.db.repository.People> optionalPeople = peopleRepository.findById(people.getId());
        if(optionalPeople.isEmpty()) {
            throw new NoSuchEntityException(people.getId());
        }
        peopleRepository.save(people.toEntity());
    }

    @Override
    public Iterable<? extends People> findByAgeGreaterThan

    public Iterable<People> getAllPeople2() {
        return StreamSupport.stream(peopleRepository.findAll().spliterator(), false)
                .map(People::new)
                .collect(Collectors.toList());
    }

}
