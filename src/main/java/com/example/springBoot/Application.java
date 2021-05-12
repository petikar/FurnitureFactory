package com.example.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("springBoot");
        logger.setLevel(Level.FINE);
        final int LOG_ROTATION_COUNT = 5;
        try {
            Handler handler = new FileHandler("%h/mylog.log", 0, LOG_ROTATION_COUNT);
            logger.addHandler(handler);
        } catch (IOException e) {
            logger.severe("Unable to create logger file");
        }

        SpringApplication.run(Application.class, args);
    }
}