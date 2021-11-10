package ua.goit.service.handler;

import lombok.AccessLevel;
import lombok.Getter;
import retrofit2.Call;
import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import ua.goit.model.Pet;
import ua.goit.service.retrofit.RetrofitPet;
import ua.goit.util.Retrofit;

import java.util.List;

public class HandlerPetGetByStatus extends CommandGet<Pet> {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"get", "pet", "findByStatus"};
    
    private final RetrofitPet retrofit = Retrofit.createClient(RetrofitPet.class);

    protected HandlerPetGetByStatus(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }
    
    @Override
    protected Pet execute(String[] command) {
        return Retrofit.execute(retrofit.getByStatus(command[3].toLowerCase())).get(0);
    }

}
