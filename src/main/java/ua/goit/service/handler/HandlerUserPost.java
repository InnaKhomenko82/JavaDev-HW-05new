package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.model.User;
import ua.goit.service.retrofit.RetrofitUser;
import ua.goit.util.Retrofit;

public class HandlerUserPost extends CommandHandler {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"post", "user"};
    
    private final RetrofitUser retrofit = Retrofit.createClient(RetrofitUser.class);

    protected HandlerUserPost(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }
    
    @Override
    protected void apply(String[] command) {
        messageSender.send("Insert user details:", "id|userName|firstName|lastName|email|password|phone|userStatus");
        User user = Retrofit.execute(retrofit.create(new User(controller.read())));
        messageSender.send("Created new user:" + user);
    }
    
}
