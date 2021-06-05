package com.example.furnitureFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
/*        Logger logger = Logger.getLogger("springBoot");
        logger.setLevel(Level.FINE);
        final int LOG_ROTATION_COUNT = 5;
        try {
            Handler handler = new FileHandler("%h/mylog.log", 0, LOG_ROTATION_COUNT);
            logger.addHandler(handler);
        } catch (IOException e) {
            logger.severe("Unable to create logger file");
        }*/

        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

/*        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }*/
    }
}