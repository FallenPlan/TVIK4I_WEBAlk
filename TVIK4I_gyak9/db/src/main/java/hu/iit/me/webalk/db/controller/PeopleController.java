package hu.iit.me.webalk.db.controller;

import org.springframework.web.bind.annotation.*;

import hu.iit.me.webalk.db.service.PeopleService;
import hu.iit.me.webalk.db.repository.People;

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

}
