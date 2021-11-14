package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.model.ApiResponse;
import ua.goit.service.retrofit.RetrofitUser;
import ua.goit.util.Retrofit;

public class HandlerUserGetLogout extends CommandHandler {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"get", "user", "logout"};
    
    private final RetrofitUser retrofit = Retrofit.createClient(RetrofitUser.class);

    protected HandlerUserGetLogout(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }
    
    @Override
    protected void apply(String[] command) {
        messageSender.send("Get user logout:");
        ApiResponse result = Retrofit.execute(retrofit.logout());
        messageSender.send(result.getMessage());
    }

    @Override
    protected String commandDescription() {
        return "Log out current logged in user session";
    }

    @Override
    protected String commandExample() {
        return "get|user|logout\n";
    }

}
