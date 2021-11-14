package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.model.ApiResponse;
import ua.goit.model.User;
import ua.goit.service.retrofit.RetrofitUser;
import ua.goit.util.Retrofit;

public class HandlerUserDelete extends CommandDelete<User> {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"delete", "user"};
    
    private final RetrofitUser retrofit = Retrofit.createClient(RetrofitUser.class);

    protected HandlerUserDelete(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }

    @Override
    protected String execute(String... command) {
        ApiResponse apiResponse = Retrofit.execute(retrofit.deleteByName(command[2]));
        messageSender.send("Deleted user:");
        return apiResponse.getMessage();
    }

    @Override
    protected String commandDescription() {
        return "Delete User";
    }

    @Override
    protected String commandExample() {
        return "~delete|user|userName~\n" +
                "delete|user|newUser\n";
    }
}
