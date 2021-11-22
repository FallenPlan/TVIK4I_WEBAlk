package hu.me.iit.webalk.dependencyPractice;

import org.springframework.stereotype.Component;

@Component
public class DependencyPracticeImpl implements DependencyPractice {
    @Override
    public void helpNoParameterNoReturnValue() {

    }

    @Override
    public int helpNoParameterReturnValue() {
        return 69;
    }

    @Override
    public void helpParameterNoReturnValue(int a) {

    }
}
