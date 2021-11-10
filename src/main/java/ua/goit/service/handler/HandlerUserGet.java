package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import ua.goit.model.User;
import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.service.retrofit.RetrofitUser;
import ua.goit.util.Retrofit;

public class HandlerUserGet extends CommandGet<User> {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"get", "user"};
    
    private final RetrofitUser retrofit = Retrofit.createClient(RetrofitUser.class);

    protected HandlerUserGet(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }

    @Override
    protected User execute(String[] command) {
        return Retrofit.execute(retrofit.getUserByName(command[2]));
    }
    
}
