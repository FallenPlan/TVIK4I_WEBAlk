package hu.me.iit.webalk.dependencyPractice;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnotherController {
    private final ApplicationContext context;

    public AnotherController(ApplicationContext context) {
        this.context = context;
    }

    @ResponseBody
    @GetMapping("/c")
    public String getARoot() {
        ServicePractice servicePractice = context.getBean("myServicePractice", ServicePractice.class);
        return servicePractice.getValue();
    }

    @ResponseBody
    @GetMapping("/beans")
    public String[] getBeans() {
        return context.getBeanDefinitionNames();
    }
}
