package hu.me.iit.webalk.singeltonPractice;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ServicePractice myServicePractice(DependencyPractice depp){
        return new ServicePracticeImpl(depp);
    }
}
