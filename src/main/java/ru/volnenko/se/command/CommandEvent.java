package ru.volnenko.se.command;

import org.springframework.context.ApplicationEvent;

public class CommandEvent extends ApplicationEvent {

    public final String command;

    public CommandEvent(Object source, String command) {
        super(source);
        this.command = command;
    }
}
