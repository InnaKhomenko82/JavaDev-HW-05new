package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;

public class HandlerHelp extends CommandHandler {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"help"};

    protected HandlerHelp(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }

    @Override
    protected void apply(String[] command) {
        messageSender.send("get|user|login|user1|1234\n" +
                "\n" +
                "get|user|user1\n" +
                "get|user|newUser\n" +
                "get|user|newUser2\n" +
                "\n" +
                "delete|user|newUser3\n" +
                "\n" +
                "post|user\n" +
                "\n" +
                "post|user|createWithList\n" +
                "\n" +
                "51658|newUser|Inna|Khomenko|inna@gmail.com|1234|987654|8\n" +
                "25419|newUser2|Inna|Khomenko|inna@gmail.com|1234|987654|8\n" +
                "85210|newUser3|Inna|Khomenko|inna@gmail.com|1234|987654|8\n" +
                "\n" +
                "post|user|createWithArray\n" +
                "516586|newUser|Inna|Khomenko|inna@gmail.com|1234|987654|8;254194|newUser2|Inna|Khomenko|inna@gmail.com|1234|987654|8;852106|newUser3|Inna|Khomenko|inna@gmail.com|1234|987654|8\n" +
                "\n" +
                "get|user|logout\n" +
                "\n" +
                "post|pet|image\n" +
                "\n" +
                "post|pet\n" +
                "\n" +
                "85262|Kleo|AVAILABLE|cats\n" +
                "25465|Ruf|AVAILABLE|ant\n" +
                "\n" +
                "put|pet\n" +
                "85262|Kleo2|AVAILABLE|cats\n" +
                "\n" +
                "get|pet|findByStatus|available\n" +
                "get|pet|findByStatus|pending\n" +
                "get|pet|findByStatus|sold\n" +
                "\n" +
                "get|pet|2\n" +
                "\n" +
                "delete|pet|2\n" +
                "\n" +
                "post|order\n" +
                "\n" +
                "2|1|30|2021-09-09|PLACED|true\n" +
                "5|3|25|2021-03-11|APPROVED|true\n" +
                "\n" +
                "get|order|2\n" +
                "\n" +
                "delete|order|2");
    }
    
}
