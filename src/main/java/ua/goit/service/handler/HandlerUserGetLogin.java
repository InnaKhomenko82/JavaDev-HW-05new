package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.model.ApiResponse;
import ua.goit.service.retrofit.RetrofitUser;
import ua.goit.util.Retrofit;

public class HandlerUserGetLogin extends CommandHandler {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"get", "user", "login"};
    
    private final RetrofitUser retrofit = Retrofit.createClient(RetrofitUser.class);

    protected HandlerUserGetLogin(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }

    @Override
    protected void apply(String[] command) {
        messageSender.send("Get user login: ", command[3]);
        messageSender.send(Retrofit.execute(retrofit.login(command[3], command[4])).getMessage());
    }

    @Override
    protected String commandDescription() {
        return "Log User into the system";
    }

    @Override
    protected String commandExample() {
        return "~get|user|login|userName|password~\n" +
                "get|user|login|user1|1234\n";
    }

    @Override
    protected int getNumberCommands() {
        return 5;
    }
    
}
