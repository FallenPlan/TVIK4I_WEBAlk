package hu.iit.me.webalk.db;

import hu.iit.me.webalk.db.repository.People;
import hu.iit.me.webalk.db.repository.PeopleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PeopleControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    public PeopleControllerTest(MockMvc mockMvc) {
//        this.mockMvc = mockMvc;
//    }

    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    public void shouldNoMainPage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void shouldReturnPeople() throws Exception {
        //GIVEN
        People people = new People(12, 1L, "1");

        Iterable<People> all = peopleRepository.findAll();
        peopleRepository.save(people);

        //WHEN THEN
        this.mockMvc.perform(get("/people"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"name\":\"1\",\"age\":12}]));

    }

    @Test
    public void shouldReturnPeople2() throws Exception {
        //GIVEN
        People people = new People(22, 1L, "2");

        Iterable<People> all = peopleRepository.findAll();
        peopleRepository.save(people);

        //WHEN THEN
        this.mockMvc.perform(get("/people"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"name\":\"2\",\"age\":22}]));

    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
