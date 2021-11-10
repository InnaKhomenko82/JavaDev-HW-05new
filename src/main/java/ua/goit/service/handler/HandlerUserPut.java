package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.model.User;
import ua.goit.service.retrofit.RetrofitUser;
import ua.goit.util.Retrofit;

public class HandlerUserPut extends CommandHandler {
    
    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"put", "user"};
    
    private final RetrofitUser retrofit = Retrofit.createClient(RetrofitUser.class);

    protected HandlerUserPut(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }
    
    @Override
    protected void apply(String[] command) {
        messageSender.send("Insert user details:\n", "id|userName|firstName|lastName|email|password|phone|userStatus");
        User user = new User(controller.read());
        User result = Retrofit.execute(retrofit.updateByName(user, user.getUserName()));
        messageSender.send("Updated new user:", result);
    }
    
}
