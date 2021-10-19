package hu.me.iit.webalk.singleton;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class SecondaryController {
    private final Service service;

    public SecondaryController(Service service) {
        this.service = service;
    }

    @ResponseBody
    @GetMapping("/b")
    public String getBRoot() {
        return service.getValue();
    }
}
