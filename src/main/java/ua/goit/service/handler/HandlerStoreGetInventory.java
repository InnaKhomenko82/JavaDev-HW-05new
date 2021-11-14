package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;

public class HandlerStoreGetInventory extends CommandHandler {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {};

    protected HandlerStoreGetInventory(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }
    
    @Override
    protected void apply(String[] command) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    protected String commandDescription() {
        return "Return Pet inventories by status";
    }

    @Override
    protected String commandExample() {
        return "\n";
    }

}
