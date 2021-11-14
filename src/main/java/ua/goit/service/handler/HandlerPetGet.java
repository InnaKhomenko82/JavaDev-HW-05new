package ua.goit.service.handler;

import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import ua.goit.model.Pet;
import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.service.retrofit.RetrofitPet;
import ua.goit.util.Retrofit;

public class HandlerPetGet extends CommandGet<Pet> {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"get", "pet"};

    private final RetrofitPet retrofit = Retrofit.createClient(RetrofitPet.class);

    protected HandlerPetGet(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }

    @Override
    protected Pet execute(String[] command) {
        return Retrofit.execute(retrofit.findById(Long.valueOf(command[2])));
    }

    @Override
    protected String commandDescription() {
        return "Find Pet by ID";
    }

    @Override
    protected String commandExample() {
        return "~get|pet|petID~\n" +
                "get|pet|2\n";
    }
}
