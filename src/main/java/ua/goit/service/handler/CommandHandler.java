package ua.goit.service.handler;

import lombok.AccessLevel;
import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class CommandHandler {

    protected final MessageSender messageSender;

    protected final Controller controller;

    protected abstract void apply(String... command);

    protected abstract String[] getProcessedCommands();

    protected abstract String commandDescription();

    protected abstract String commandExample();

    protected String section(){
        return getProcessedCommands()[1];
    };

    //default implementation
    protected int getNumberCommands() {
        return getProcessedCommands().length;
    }

}
