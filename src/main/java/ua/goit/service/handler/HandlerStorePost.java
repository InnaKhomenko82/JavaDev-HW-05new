package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.model.Order;
import ua.goit.service.retrofit.RetrofitOrder;
import ua.goit.util.Retrofit;

public class HandlerStorePost extends CommandHandler {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"post", "order"};
    
    private final RetrofitOrder retrofit = Retrofit.createClient(RetrofitOrder.class);

    protected HandlerStorePost(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }
    
    @Override
    protected void apply(String[] command) {
        messageSender.send("Insert order details:", "id|petID|quantity|shipDate|status|complete");
        Order order = Retrofit.execute(retrofit.create(new Order(controller.read())));
        messageSender.send("Created new order:", order);
    }
    
}
