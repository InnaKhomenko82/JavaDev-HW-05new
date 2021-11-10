package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.model.Order;
import ua.goit.service.retrofit.RetrofitOrder;
import ua.goit.util.Retrofit;

public class HandlerStoreDelete extends CommandDelete<Order> {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"delete", "order"};
    
    private final RetrofitOrder retrofit = Retrofit.createClient(RetrofitOrder.class);

    protected HandlerStoreDelete(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }

    @Override
    protected void execute(String... command) {
        Retrofit.execute(retrofit.deleteById(Long.valueOf(command[2])));
    }
}
