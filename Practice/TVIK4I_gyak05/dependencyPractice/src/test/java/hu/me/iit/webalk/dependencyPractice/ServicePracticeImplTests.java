package hu.me.iit.webalk.dependencyPractice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServicePracticeImplTests {

    @Mock
    DependencyPractice dependencyPractice;

    @InjectMocks ServicePracticeImpl servicePractice;

    @Test
    void calculateTest() {
        //GIVEN

        //WHEN
        servicePractice.calculateValue();

        //THEN
        verify(dependencyPractice, times(1)).helpNoParameterNoReturnValue();

    }

    @Test
    void return10() {
        //GIVEN
        final int TEN = 10;

        //WHEN
        int result = servicePractice.return10();

        //THEN
        assertEquals(TEN, result);
    }

    @Test
    void dependencyReturnValueIsUsed() {
        //GIVEN
        final int TEN = 10;

        when(dependencyPractice.helpNoParameterReturnValue()).thenReturn(TEN);

        //WHEN
        int result = servicePractice.callHelpAndUseReturnValue();

        //THEN
        verify(dependencyPractice, times(1)).helpNoParameterReturnValue();
        assertEquals(TEN, result);
    }

    @Test
    void callHelpAndPassParameter10Test() {
        //GIVEN
        final int TEN = 10;

        //WHEN
        servicePractice.callHelpAndPassParameter10();

        //THEN
        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);

        verify(dependencyPractice, times(1)).helpParameterNoReturnValue(captor.capture());
        assertEquals(TEN, captor.getValue());
    }

//    String getImportantAbstract(String name) {
//        final String pont = "...";
//        String longMessage = name.concat(pont);
//
//
//
//        //String important(String text)
//        //helper.important();
//        return longMessage;
//    }
}
