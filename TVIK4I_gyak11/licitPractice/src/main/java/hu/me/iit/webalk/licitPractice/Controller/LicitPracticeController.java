package hu.me.iit.webalk.licitPractice.Controller;

import hu.me.iit.webalk.licitPractice.Service.LicitPracticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class LicitPracticeController {
    private final LicitPracticeService licitPracticeService;

    public LicitPracticeController(LicitPracticeService licitPracticeService) {
        this.licitPracticeService = licitPracticeService;
    }

    @GetMapping("/licit/lowest")
    public int getLowest() {
        return licitPracticeService.getLowest();
    }

    @GetMapping("/licit/lowest/{user}")
    public int getLowestForUser(@PathVariable int userId) {
        return licitPracticeService.getLowestForUser(userId);
    }

    @PostMapping
    public void saveNewLicit(@RequestBody @Valid SaveLicitPracticeDto saveLicitPracticeDto) {
        licitPracticeService.saveNewLicit(saveLicitPracticeDto.getLicit(), saveLicitPracticeDto.getUserId());
    }
}
