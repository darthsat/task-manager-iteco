package ru.volnenko.se.controller;

import org.springframework.stereotype.Component;
import ru.volnenko.se.api.controller.TaskManagerInput;

import java.util.Scanner;

@Component
public class TaskManagerScanner implements TaskManagerInput {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public Integer nextInteger() {
        final String value = nextLine();
        if (value == null || value.isEmpty()) return null;
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return null;
        }
    }
}