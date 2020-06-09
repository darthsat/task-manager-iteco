package ru.volnenko.se.command.system;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.command.CommandEvent;

import java.util.List;

/**
 * @author Denis Volnenko
 */
@Component
public final class HelpCommand implements AbstractCommand {

    private final List<AbstractCommand> commandList;

    public HelpCommand(List<AbstractCommand> commandList) {
        this.commandList = commandList;
        this.commandList.add(this);
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

    @Override
    @EventListener(condition = "#event.command eq 'help'")
    public void processEvent(CommandEvent event)  {
        execute();
    }
}
