package com.jan;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ExecutorTest {

    IChallange codelandUserNameValidation;

    @BeforeEach
    public void before() {
        codelandUserNameValidation = mock(IChallange.class);
        when(codelandUserNameValidation.execute(any(Object.class))).thenReturn(new Object());
    }

    @Test
    void testMain (){
        Executor.main(new String[]{});
    }

    @Test
    void testRun (){
        new Executor(codelandUserNameValidation).run();
    }
}
