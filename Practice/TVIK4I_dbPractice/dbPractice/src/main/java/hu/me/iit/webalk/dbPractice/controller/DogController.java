package hu.me.iit.webalk.dbPractice.controller;

import hu.me.iit.webalk.dbPractice.service.Dog;
import hu.me.iit.webalk.dbPractice.service.DogService;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dog")
public class DogController {
    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public Iterable<DogDto> getAllDog() {
        List<DogDto> dogDtoList = new ArrayList<>();
        for (Dog dog : dogService.getAllDog()) {
            dogDtoList.add(new DogDto(dog));
        }
        return dogDtoList;
    }

    @PostMapping(consumes = "application/json")
    public DogDto save(@RequestBody @Valid DogCreateDto dogCreateDto) {
        return new DogDto(dogService.create(dogCreateDto.toDog()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        dogService.delete(id);
    }

    @GetMapping("/{id}")
    public DogDto getById(@PathVariable("id") Long id) {
        return new DogDto(dogService.getById(id));
    }

    @PutMapping
    void save(@RequestBody @Valid DogDto dogDto) {
        dogService.save(dogDto.toDog());
    }

    @GetMapping("/findByAgeGt")
    Iterable<DogDto> findAdultDog(@RequestParam("age") int age) {
        List<hu.me.iit.webalk.dbPractice.controller.DogDto> dogDtoList = new ArrayList<>();
        for (Dog dog : dogService.findByAgeGreaterThan(age)) {
            dogDtoList.add(new hu.me.iit.webalk.dbPractice.controller.DogDto(dog));
        }
        return dogDtoList;
    }
}
