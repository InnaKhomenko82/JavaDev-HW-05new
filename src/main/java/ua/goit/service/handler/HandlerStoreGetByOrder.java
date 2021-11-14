package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import ua.goit.model.Order;
import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.service.retrofit.RetrofitOrder;
import ua.goit.util.Retrofit;

public class HandlerStoreGetByOrder extends CommandGet<Order> {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"get", "order"};
    
    private final RetrofitOrder retrofit = Retrofit.createClient(RetrofitOrder.class);

    protected HandlerStoreGetByOrder(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }

    @Override
    protected Order execute(String[] command) {
        return Retrofit.execute(retrofit.findById(Long.valueOf(command[2])));
    }

    @Override
    protected String commandDescription() {
        return "Find purchase order by ID";
    }

    @Override
    protected String commandExample() {
        return "~get|order|orderID~\n" +
                "get|order|2\n";
    }
}
