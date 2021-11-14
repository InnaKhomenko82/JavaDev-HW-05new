package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.model.ApiResponse;
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
    protected String execute(String... command) {
        ApiResponse apiResponse = Retrofit.execute(retrofit.deleteById(Long.valueOf(command[2])));
        messageSender.send("Deleted order:");
        return apiResponse.getMessage();
    }

    @Override
    protected String commandDescription() {
        return "Delete purchase order by ID";
    }

    @Override
    protected String commandExample() {
        return "~delete|order|orderID~\n" +
                "delete|order|2\n";
    }
}
