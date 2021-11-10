package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;

public class HandlerPetPostImage extends CommandHandler {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"post", "pet", "image"};

    protected HandlerPetPostImage(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }

    @Override
    protected void apply(String[] command) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    protected int getNumberCommands() {
        return 4;
    }
    
}
