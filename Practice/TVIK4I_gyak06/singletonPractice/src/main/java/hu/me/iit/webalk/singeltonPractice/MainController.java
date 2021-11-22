package hu.me.iit.webalk.singeltonPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private ServicePractice servicePractice;

    @Autowired
    public void setServicePractice(ServicePractice servicePractice) {
        this.servicePractice = servicePractice;
    }

    @ResponseBody
    @GetMapping("/a")
    public String getARoot() {
        return servicePractice.getValue();
    }
}
