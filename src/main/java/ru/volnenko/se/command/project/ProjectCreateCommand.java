package ru.volnenko.se.command.project;

import org.springframework.stereotype.Component;
import ru.volnenko.se.api.controller.TaskManagerInput;
import ru.volnenko.se.api.repository.IProjectRepository;
import ru.volnenko.se.command.AbstractCommand;

/**
 * @author Denis Volnenko
 */
@Component
public final class ProjectCreateCommand implements AbstractCommand {

    private final IProjectRepository projectRepository;
    private final TaskManagerInput input;

    public ProjectCreateCommand(IProjectRepository projectRepository, TaskManagerInput input) {
        this.projectRepository = projectRepository;
        this.input = input;
    }

    @Override
    public String description() {
        return "Create new project.";
    }

    @Override
    public String command() {
        return "project-create";
    }

    @Override
    public void execute() {
        System.out.println("[PROJECT CREATE]");
        System.out.println("ENTER NAME:");
        final String name = input.nextLine();
        projectRepository.createProject(name);
        System.out.println("[OK]");
        System.out.println();
    }

}
