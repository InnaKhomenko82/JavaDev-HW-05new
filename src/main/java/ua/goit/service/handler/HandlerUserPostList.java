package ua.goit.service.handler;

import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;

public class HandlerUserPostList extends CommandHandler {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"post", "user", "createWithList"};
    
    private final CommandHandler handler = new HandlerUserPut(messageSender, controller);

    protected HandlerUserPostList(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }

    @Override
    protected void apply(String[] command) {
        while (true) {           
            handler.apply("put", "user");
            messageSender.send("Enter any symbol to continue or 'N' to close the list");
            if ("N".equalsIgnoreCase(controller.read()[0])) break;
        }
    }

}
