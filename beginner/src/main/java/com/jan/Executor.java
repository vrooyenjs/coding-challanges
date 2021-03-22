package com.jan;

import com.jan.interfaces.IChallange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class Executor implements CommandLineRunner {

    IChallange codelandUserNameValidation;

    @Autowired
    public Executor(IChallange codelandUserNameValidation) {
        this.codelandUserNameValidation = codelandUserNameValidation;

    }

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
