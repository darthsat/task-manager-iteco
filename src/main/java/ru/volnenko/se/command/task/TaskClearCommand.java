package ru.volnenko.se.command.task;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.api.repository.ITaskRepository;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.command.CommandEvent;

/**
 * @author Denis Volnenko
 */
@Component
public final class TaskClearCommand implements AbstractCommand {

    private final ITaskRepository taskRepository;

    public TaskClearCommand(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public String description() {
        return "Remove all tasks.";
    }

    @Override
    @EventListener(condition = "#event.command eq 'task-clear'")
    public void processEvent(CommandEvent event)  {
        execute();
    }

    @Override
    public String command() {
        return "task-clear";
    }

    @Override
    public void execute() {
        taskRepository.clear();
        System.out.println("[ALL TASK REMOVED]");
    }

}
