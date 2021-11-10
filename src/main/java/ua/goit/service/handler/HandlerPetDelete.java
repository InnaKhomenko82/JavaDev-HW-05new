package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.model.ApiResponse;
import ua.goit.model.Pet;
import ua.goit.service.retrofit.RetrofitPet;
import ua.goit.util.Retrofit;

public class HandlerPetDelete extends CommandDelete<Pet> {
    
    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"delete", "pet"};
    
    private final RetrofitPet retrofit = Retrofit.createClient(RetrofitPet.class);
    
    protected HandlerPetDelete(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }

    @Override
    protected void execute(String... command) {
        Retrofit.execute(retrofit.deleteById(Long.valueOf(command[2])));
    }
}
