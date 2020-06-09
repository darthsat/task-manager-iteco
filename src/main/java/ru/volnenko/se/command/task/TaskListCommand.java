package ru.volnenko.se.command.task;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.api.repository.ITaskRepository;
import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.command.CommandEvent;
import ru.volnenko.se.entity.Task;

/**
 * @author Denis Volnenko
 */
@Component
public final class TaskListCommand implements AbstractCommand {

    private final ITaskRepository taskRepository;

    public TaskListCommand(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public String command() {
        return "task-list";
    }

    @Override
    public String description() {
        return "Show all tasks.";
    }

    @Override
    @EventListener(condition = "#event.command eq 'task-list'")
    public void processEvent(CommandEvent event)  {
        execute();
    }

    @Override
    public void execute() {
        System.out.println("[TASK LIST]");
        int index = 1;
        for (Task task: taskRepository.getListTask()) {
            System.out.println(index + ". " + task.getName());
            index++;
        }
        System.out.println();
    }

}
