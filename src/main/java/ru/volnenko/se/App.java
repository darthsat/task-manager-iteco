package ru.volnenko.se;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.volnenko.se.api.controller.Runner;
import ru.volnenko.se.config.TaskManagerConfiguration;

public class App {
    public static void main(String[] args) throws Exception {
        new AnnotationConfigApplicationContext(TaskManagerConfiguration.class).getBean(Runner.class).run();
    }
}
