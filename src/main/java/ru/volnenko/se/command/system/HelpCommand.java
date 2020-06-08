package ru.volnenko.se.command.system;

import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;

import java.util.List;

/**
 * @author Denis Volnenko
 */
@Component
public final class HelpCommand implements AbstractCommand {

    private final List<AbstractCommand> commandList;

    public HelpCommand(List<AbstractCommand> commandList) {
        this.commandList = commandList;
    }

    @Override
    public String command() {
        return "help";
    }

    @Override
    public String description() {
        return "Show all commands.";
    }

    @Override
    public void execute() {
        for (AbstractCommand command: commandList) {
            System.out.println(command.command()+ ": " + command.description());
        }
    }

}
