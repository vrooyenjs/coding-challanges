package com.jan;

import com.jan.interfaces.IChallange;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Slf4j
@EnableAspectJAutoProxy
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
@Setter
@SpringBootApplication
public class Executor implements CommandLineRunner {

    IChallange codelandUserNameValidation;
    IChallange findIntersection;
    IChallange firstFactorial;
    IChallange firstReverse;
    IChallange longestWord;
    IChallange questionsMarks;


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Executor.class);
        app.run(args);
    }

    @Override
    public void run(String... args) {
        //check if user passes any argument
        codelandUserNameValidation.execute("Testing");
    }
}
