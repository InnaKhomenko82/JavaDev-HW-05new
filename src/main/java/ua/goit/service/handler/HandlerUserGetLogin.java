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
        ApiResponse result = Retrofit.execute(retrofit.login(command[3], command[4]));
        messageSender.send(result.getMessage());
    }

    @Override
    protected int getNumberCommands() {
        return 5;
    }
    
}
