package ua.goit.service.handler;

import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;

public class HandlerUserPostList extends CommandHandler {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"post", "user", "createWithList"};
    
    private final CommandHandler handler = new HandlerUserPost(messageSender, controller);

    protected HandlerUserPostList(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }

    @Override
    protected void apply(String[] command) {
        while (true) {           
            handler.apply("post", "user");
            messageSender.send("Enter any symbol to continue or 'N' to close the list");
            if ("N".equalsIgnoreCase(controller.read()[0])) break;
        }
    }

    @Override
    protected String commandDescription() {
        return "Create list of Users";
    }

    @Override
    protected String commandExample() {
        return "post|user|createWithList\n" +
                "~id|userName|firstName|lastName|email|password|phone|userStatus~\n" +
                "51658|newUser|Inna|Khomenko|inna@gmail.com|1234|987654|8\n" +
                "25419|newUser2|Inna|Khomenko|inna@gmail.com|1234|987654|8\n" +
                "85210|newUser3|Inna|Khomenko|inna@gmail.com|1234|987654|8\n";
    }

}
