package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.model.Pet;
import ua.goit.service.retrofit.RetrofitPet;
import ua.goit.util.Retrofit;

public class HandlerPetPost extends CommandHandler {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"post", "pet"};

    private final RetrofitPet retrofit = Retrofit.createClient(RetrofitPet.class);

    protected HandlerPetPost(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }

    @Override
    protected void apply(String[] command) {
        messageSender.send("Insert pet details:", "id|name|status|category");
        Pet pet = new Pet(controller.read());
        Retrofit.execute(retrofit.create(pet));
        messageSender.send("Created new order:", pet);
    }

}
