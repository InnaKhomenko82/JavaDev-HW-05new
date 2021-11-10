package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.model.Pet;
import ua.goit.service.retrofit.RetrofitPet;
import ua.goit.util.Retrofit;

public class HandlerPetPut extends CommandHandler {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"put", "pet"};
    
    private final RetrofitPet retrofit = Retrofit.createClient(RetrofitPet.class);

    protected HandlerPetPut(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }
    
    @Override
    protected void apply(String[] command) {
        messageSender.send("Insert pet details:", "id|name|status|category");
        Pet pet = Retrofit.execute(retrofit.update(new Pet(controller.read())));
        messageSender.send("Updated new pet:", pet);
    }

}
