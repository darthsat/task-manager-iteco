package ru.volnenko.se.controller;

import org.springframework.stereotype.Controller;
import ru.volnenko.se.api.controller.Runner;
import ru.volnenko.se.api.controller.TaskManagerInput;
import ru.volnenko.se.command.AbstractCommand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Denis Volnenko
 */
@Controller
public final class RunnerImpl implements Runner {

    private final Map<String, AbstractCommand> commands = new HashMap<>();

    private final TaskManagerInput input;

    public RunnerImpl(final List<AbstractCommand> commandsList, TaskManagerInput input) {
        this.input = input;
        commandsList.forEach(cliCommand -> commands.put(cliCommand.command(), cliCommand));
    }

    @Override
    public void run() throws Exception {
        System.out.println("*** WELCOME TO TASK MANAGER ***");
        String command = "";
        while (!"exit".equals(command)) {
            command = input.nextLine();
            execute(command);
        }
    }

    private void execute(final String command) throws Exception {
        if (command == null || command.isEmpty()) return;
        final AbstractCommand abstractCommand = commands.get(command);
        if (abstractCommand == null) return;
        abstractCommand.execute();
    }
}
