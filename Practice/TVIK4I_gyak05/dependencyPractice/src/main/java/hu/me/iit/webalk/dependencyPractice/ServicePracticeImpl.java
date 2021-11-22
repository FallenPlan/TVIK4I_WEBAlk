package hu.me.iit.webalk.dependencyPractice;

import org.springframework.beans.factory.annotation.Value;

public class ServicePracticeImpl implements ServicePractice {
    private final DependencyPractice dependencyPractice;
    private String value;

    @Value("${my-stuff}")
    public void setValue(String value) {
        this.value = value;
    }

    public ServicePracticeImpl(DependencyPractice dependencyPractice) {
        this.dependencyPractice = dependencyPractice;
    }

    @Override
    public void calculateValue() {
        dependencyPractice.helpNoParameterNoReturnValue();
    }

    @Override
    public String getValue() {
        return value;
    }

    public int return10() {
        return 10;
    }

    public int callHelpAndUseReturnValue() {
        return dependencyPractice.helpNoParameterReturnValue();
    }

    public void callHelpAndPassParameter10() {
        dependencyPractice.helpParameterNoReturnValue(10);
    }
}
