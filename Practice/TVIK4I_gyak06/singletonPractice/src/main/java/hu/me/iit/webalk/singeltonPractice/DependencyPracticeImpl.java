package hu.me.iit.webalk.singeltonPractice;

import org.springframework.stereotype.Component;

@Component
public class DependencyPracticeImpl implements DependencyPractice {
    @Override
    public void helpNoParameterNoReturnValue() {

    }

    @Override
    public int helpNoParameterReturnValue() {
        return 80;
    }

    @Override
    public void helpParameterNoReturnValue(int a) {

    }
}
