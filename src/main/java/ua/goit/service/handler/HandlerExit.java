package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;

public class HandlerExit extends CommandHandler {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"exit"};

    protected HandlerExit(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }
    
    @Override
    protected void apply(String[] command) {
        messageSender.send("Have a nice day)))");
        System.exit(0);
    }

    @Override
    protected String commandDescription() {
        return "Stop the application";
    }

    @Override
    protected String commandExample() {
        return "exit\n";
    }

}
