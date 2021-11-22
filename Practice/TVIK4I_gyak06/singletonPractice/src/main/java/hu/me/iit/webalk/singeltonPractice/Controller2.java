package hu.me.iit.webalk.singeltonPractice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {
    private final ServicePractice servicePractice;

    public Controller2(ServicePractice servicePractice) {
        this.servicePractice = servicePractice;
    }

    @ResponseBody
    @GetMapping("/b")
    public String getBRoot() {
        return servicePractice.getValue();
    }
}
