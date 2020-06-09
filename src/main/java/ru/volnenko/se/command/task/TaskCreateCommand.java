package ru.volnenko.se.command.task;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.api.controller.TaskManagerInput;
import ru.volnenko.se.api.repository.ITaskRepository;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.command.CommandEvent;

/**
 * @author Denis Volnenko
 */
@Component
public final class TaskCreateCommand implements AbstractCommand {

    private final ITaskRepository taskRepository;
    private final TaskManagerInput input;

    public TaskCreateCommand(ITaskRepository taskRepository, TaskManagerInput input) {
        this.taskRepository = taskRepository;
        this.input = input;
    }

    @Override
    public String command() {
        return "task-create";
    }

    @Override
    public String description() {
        return "Create new task.";
    }

    @Override
    @EventListener(condition = "#event.command eq 'task-create'")
    public void processEvent(CommandEvent event)  {
        execute();
    }

    @Override
    public void execute() {
        System.out.println("[TASK CREATE]");
        System.out.println("ENTER NAME:");
        final String name = input.nextLine();
        taskRepository.createTask(name);
        System.out.println("[OK]");
        System.out.println();
    }

}
