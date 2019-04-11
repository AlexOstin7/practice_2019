package ru.bellintegrator.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


//@EnableSwagger2
@ImportResource("spring_mvc_config.xml")
@SpringBootApplication
//@ComponentScan(basePackageClasses = {DummyControllerImpl.class, DummyServiceImpl.class, PersonDAOImpl.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }
}