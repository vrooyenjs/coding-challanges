package com.jan;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ExecutorTest {

    IChallange codelandUserNameValidation;

    @BeforeEach
    void before() {
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
