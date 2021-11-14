package ua.goit.service.handler;

import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.controller.ConsoleController;
import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import ua.goit.model.User;
import ua.goit.service.retrofit.RetrofitUser;
import ua.goit.util.Retrofit;

public class HandlerUserPostArray extends CommandHandler{
    protected HandlerUserPostArray(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }

    private final RetrofitUser retrofit = Retrofit.createClient(RetrofitUser.class);

    @Override
    protected void apply(String... command) {
        messageSender.send("Insert array with user details:\n" +
                "id|userName|firstName|lastName|email|password|phone|userStatus;\n" +
                "id|userName|firstName|lastName|email|password|phone|userStatus");
        String[] userString = controller.readArray();
        for (int i=0; i<userString.length; i++) {
            String[] parameters = userString[i].split("\\|");
            User user = new User(parameters);
            Retrofit.execute(retrofit.create(user));
            messageSender.send("Created new user:" + user);
        }
    }

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"post", "user", "createWithArray"};


    @Override
    protected String commandDescription() {
        return "Create list of Users with array";
    }

    @Override
    protected String commandExample() {
        return "post|user|createWithArray\n" +
                "516586|newUser|Inna|Khomenko|inna@gmail.com|1234|987654|8;254194|newUser2|Inna|Khomenko|inna@gmail.com|1234|987654|8;852106|newUser3|Inna|Khomenko|inna@gmail.com|1234|987654|8\n";
    }
}
