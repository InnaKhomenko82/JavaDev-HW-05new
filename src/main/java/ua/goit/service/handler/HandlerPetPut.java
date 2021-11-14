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
        Pet pet = new Pet(controller.read());
        Retrofit.execute(retrofit.update(pet));
        messageSender.send("Updated pet:", pet);
    }

    @Override
    protected String commandDescription() {
        return "Update an existing Pet";
    }

    @Override
    protected String commandExample() {
        return "put|pet\n" +
                "~id|name|status|category~\n" +
                "85262|Kleo2|AVAILABLE|cats\n";
    }

}
