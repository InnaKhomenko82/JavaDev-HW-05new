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
        Order order = new Order(controller.read());
        Retrofit.execute(retrofit.create(order));
        messageSender.send("Created new order:", order);
    }

    @Override
    protected String commandDescription() {
        return "Place an order for a Pet";
    }

    @Override
    protected String commandExample() {
        return "post|order" +
                "\n~id|petID|quantity|shipDate|status|complete~" +
                "\n2|1|30|2021-09-09|PLACED|true\n" +
                "5|3|25|2021-03-11|APPROVED|true\n";
    }

}
