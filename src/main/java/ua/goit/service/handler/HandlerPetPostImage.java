package ua.goit.service.handler;

import okhttp3.MultipartBody;
import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.service.retrofit.RetrofitPet;
import ua.goit.util.Retrofit;

public class HandlerPetPostImage extends CommandHandler {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"post", "pet", "image"};

    private final RetrofitPet retrofit = Retrofit.createClient(RetrofitPet.class);

    protected HandlerPetPostImage(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }

    @Override
    protected void apply(String[] command) {
        System.out.println("image");
        MultipartBody.Part formData = MultipartBody.Part.createFormData(command[4], command[5]);
        Retrofit.execute(retrofit.uploadImage(Long.valueOf(command[3]), formData,formData));
    }

    @Override
    protected String commandDescription() {
        return "Upload a Pet image";
    }

    @Override
    protected String commandExample() {
        return "post|pet|image|petID|image|\n" +
                "post|pet|image|85262|https://i.redd.it/z1gnwuqqyrw71.jpg";
    }

    @Override
    protected int getNumberCommands() {
        return 5;
    }
    
}
