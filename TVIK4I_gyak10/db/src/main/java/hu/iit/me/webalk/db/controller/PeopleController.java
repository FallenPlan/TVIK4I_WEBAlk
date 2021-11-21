package hu.iit.me.webalk.db.controller;

import org.springframework.web.bind.annotation.*;

import hu.iit.me.webalk.db.service.PeopleService;
import hu.iit.me.webalk.db.service.People;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {
    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public Iterable<PeopleDto> getAllPeople() {
        List<PeopleDto> peopleDtoList = new ArrayList<>();
        for (People people : peopleService.getAllPeople()) {
            peopleDtoList.add(new PeopleDto(people));
        }
        return peopleDtoList;
    }

    @PostMapping(consumes = "application/json")
    public PeopleDto save(@RequestBody @Valid PeopleCreateDto peopleCreateDto) {
        return new PeopleDto(peopleService.create(peopleCreateDto.toPeople()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        peopleService.delete(id);
    }

    @GetMapping("/{id}")
    public PeopleDto getById(@PathVariable("id") Long id) {
        return new PeopleDto(peopleService.getById(id));
    }

    @PutMapping
    void save(@RequestBody @Valid PeopleDto peopleDto) {
        peopleService.save(peopleDto.toPeople());
    }

    @GetMapping("/findByAgeGt")
    Iterable<PeopleDto> findAdultPeople(@RequestParam("age") int age) {
        List<hu.iit.me.webalk.db.controller.PeopleDto> peopleDtoList = new ArrayList<>();
        for (People people : peopleService.findByAgeGreaterThan(age)) {
            peopleDtoList.add(new hu.iit.me.webalk.db.controller.PeopleDto(people));
        }
        return peopleDtoList;
    }

}
