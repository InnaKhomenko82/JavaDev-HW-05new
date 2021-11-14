package ua.goit.service.handler;

import retrofit2.Call;
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
        User user = new User(controller.read());
        Retrofit.execute(retrofit.create(user));
        messageSender.send("Created new user:" + user);
    }

    @Override
    protected String commandDescription() {
        return "Create User";
    }

    @Override
    protected String commandExample() {
        return "post|user\n" +
                "~id|userName|firstName|lastName|email|password|phone|userStatus~\n" +
                "51658|newUser|Inna|Khomenko|inna@gmail.com|1234|987654|8\n" +
                "25419|newUser2|Inna|Khomenko|inna@gmail.com|1234|987654|8\n" +
                "85210|newUser3|Inna|Khomenko|inna@gmail.com|1234|987654|8\n";
    }

}
