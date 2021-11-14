package ua.goit.controller;

import java.util.Arrays;
import java.util.Scanner;

import ua.goit.service.handler.CommandExecutor;

public class ConsoleController implements Controller, MessageSender {

    private final Scanner scanner = new Scanner(System.in);


    public void mainMenu() {

        CommandExecutor commandExecutor = new CommandExecutor(this, this);


        System.out.println("Hello, friend!");
        while (true) {
            System.out.println("Choose your command, 'help' or 'exit':");
            commandExecutor.handle(read());
        }
    }

    @Override
    public String[] read() {
        String command = scanner.next();
        return command.split("\\|");
    }

    @Override
    public String[] readArray() {
        String users = scanner.next();
        return users.split(";");
    }

    @Override
    public void send(Object... message) {
        Arrays.stream(message).forEach(System.out::println);
    }

}
