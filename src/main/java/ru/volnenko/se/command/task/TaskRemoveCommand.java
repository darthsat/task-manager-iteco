package ru.volnenko.se.command.task;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.api.controller.TaskManagerInput;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.command.CommandEvent;

/**
 * @author Denis Volnenko
 */
@Component
public final class TaskRemoveCommand implements AbstractCommand {

    private final TaskManagerInput input;

    public TaskRemoveCommand(TaskManagerInput input) {
        this.input = input;
    }

    @Override
    public String command() {
        return "task-remove";
    }

    @Override
    public String description() {
        return "Remove selected task.";
    }

    @Override
    public void execute() {
        System.out.println("[REMOVING TASK]");
        System.out.println("Enter task order index:");
        final Integer orderIndex = input.nextInteger();
        if (orderIndex == null) {
            System.out.println("Error! Incorrect order index...");
            System.out.println();
            return;
        }
        System.out.println("[OK]");
    }

    @Override
    @EventListener(condition = "#event.command eq 'task-remove'")
    public void processEvent(CommandEvent event)  {
        execute();
    }

}
