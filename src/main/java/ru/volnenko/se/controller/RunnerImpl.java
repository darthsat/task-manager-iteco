package ru.volnenko.se.controller;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import ru.volnenko.se.api.controller.Runner;
import ru.volnenko.se.api.controller.TaskManagerInput;
import ru.volnenko.se.command.CommandEvent;

/**
 * @author Denis Volnenko
 */
@Controller
public final class RunnerImpl implements Runner {

    private final ApplicationEventPublisher publisher;

    private final TaskManagerInput input;

    public RunnerImpl(ApplicationEventPublisher publisher, TaskManagerInput input) {
        this.publisher = publisher;
        this.input = input;
    }

    @Override
    public void run() throws Exception {
        System.out.println("*** WELCOME TO TASK MANAGER ***");
        String command = "";
        while (!"exit".equals(command)) {
            publisher.publishEvent(new CommandEvent(this, input.nextLine()));
        }
    }
}
