package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.service.retrofit.RetrofitOrder;
import ua.goit.util.Retrofit;

import java.util.Map;

public class HandlerStoreGetInventory extends CommandHandler {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"get", "store", "inventory"};

    private final RetrofitOrder retrofit = Retrofit.createClient(RetrofitOrder.class);

    protected HandlerStoreGetInventory(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }
    
    @Override
    protected void apply(String[] command) {
        Map<String, Integer> map = Retrofit.execute(retrofit.getInventory());
        messageSender.send(map);
    }

    @Override
    protected String commandDescription() {
        return "Return Pet inventories by status";
    }

    @Override
    protected String commandExample() {
        return "get|store|inventory\n";
    }

}
