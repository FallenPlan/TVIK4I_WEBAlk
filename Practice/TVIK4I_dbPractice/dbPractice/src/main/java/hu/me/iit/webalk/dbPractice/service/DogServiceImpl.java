package hu.me.iit.webalk.dbPractice.service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import hu.me.iit.webalk.dbPractice.repository.DogRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DogServiceImpl implements DogService{
    private final DogRepository dogRepository;

    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public Iterable<Dog> getAllDog() {
        List<Dog> rv = new ArrayList<>();

        for (hu.me.iit.webalk.dbPractice.repository.Dog dog : dogRepository.findAll()) {
            rv.add(new Dog(dog));
        }
        return rv;
    }

    @Override
    public Dog create(Dog dog) {
        return new Dog(dogRepository.save(dog.toEntity()));
    }

    @Override
    public void delete(Long id) {
        try {
            dogRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new NoSuchEntityException(id);
        }
    }

    @Override
    public Dog getById(Long id) {
        Optional<hu.me.iit.webalk.dbPractice.repository.Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isEmpty()) {
            throw new NoSuchEntityException(id);
        }
        return new Dog(optionalDog.get());
    }

    @Override
    public void save(Dog dog) {
        Optional<hu.me.iit.webalk.dbPractice.repository.Dog> optionalDog = dogRepository.findById(dog.getId());
        if(optionalDog.isEmpty()) {
            throw new NoSuchEntityException(dog.getId());
        }
        dogRepository.save(dog.toEntity());
    }

    @Override
    public Iterable<? extends Dog> findByAgeGreaterThan(int age) {
        return StreamSupport.stream(dogRepository.findAllByAgeGreaterThanEqual(age).spliterator(), false)
                .map(Dog::new)
                .collect(Collectors.toList());
    }

    public Iterable<Dog> getAllDog2() {
        return StreamSupport.stream(dogRepository.findAll().spliterator(), false)
                .map(Dog::new)
                .collect(Collectors.toList());
    }
}
