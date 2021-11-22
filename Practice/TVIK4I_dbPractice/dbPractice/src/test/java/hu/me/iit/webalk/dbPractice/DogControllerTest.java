package hu.me.iit.webalk.dbPractice;

import hu.me.iit.webalk.dbPractice.repository.Dog;
import hu.me.iit.webalk.dbPractice.repository.DogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class DogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DogRepository dogRepository;

    @Test
    public void shouldNoMainPage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void shouldReturnDog() throws Exception {
        //GIVEN
        Dog dog = new Dog(1L, 3, "1");

        Iterable<Dog> all = dogRepository.findAll();
        dogRepository.save(dog);

        //WHEN THEN
        this.mockMvc.perform(get("/dog"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name", is("1")))
                .andExpect(jsonPath("$.[0].age", is(12)));

    }

    @Test
    public void shouldReturnDog2() throws Exception {
        //GIVEN
        Dog dog = new Dog(1L, 4, "2");

        Iterable<Dog> all = dogRepository.findAll();
        dogRepository.save(dog);

        //WHEN THEN
        this.mockMvc.perform(get("/dog"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name", is("2")))
                .andExpect(jsonPath("$.[0].age", is(22)));

    }
}
