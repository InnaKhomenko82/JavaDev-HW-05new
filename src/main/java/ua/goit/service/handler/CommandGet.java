package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import ua.goit.exception.HttpException;
import ua.goit.model.BaseEntity;

public abstract class CommandGet<T extends BaseEntity> extends CommandHandler {

    protected CommandGet(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }

    @Override
    protected void apply(String[] command) {
        try {
            messageSender.send("Get entity: " + command[2]);
            messageSender.send(execute(command));
        } catch (HttpException e) {
            if (e.getHttpCode() == 404) messageSender.send("No such entity((");
            else throw new HttpException(e.getHttpCode(), e.getMessage(), e);
        }
    }

    protected abstract T execute(String[] command);

    @Override
    protected int getNumberCommands() {
        return getProcessedCommands().length + 1;
    }
}
