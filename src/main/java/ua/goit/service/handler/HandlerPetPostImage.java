package ua.goit.service.handler;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import ua.goit.controller.Controller;
import ua.goit.controller.MessageSender;
import lombok.AccessLevel;
import lombok.Getter;
import ua.goit.service.retrofit.RetrofitPet;
import ua.goit.util.Retrofit;

import java.io.File;

public class HandlerPetPostImage extends CommandHandler {

    @Getter(AccessLevel.PROTECTED)
    private final String[] processedCommands = {"post", "pet", "image"};

    private final RetrofitPet retrofit = Retrofit.createClient(RetrofitPet.class);

    protected HandlerPetPostImage(MessageSender messageSender, Controller controller) {
        super(messageSender, controller);
    }

    @Override
    protected void apply(String[] command) {
        File fileName = new File(command[5]);
        MultipartBody.Part additionalMetadata = MultipartBody.Part.createFormData("additionalMetadata", command[4]);
        MultipartBody.Part file = MultipartBody.Part
                .createFormData("file", fileName.getName(),
                        RequestBody.create(MediaType.parse("images/*"), fileName));
        messageSender.send(Retrofit.execute(retrofit.uploadImage(Long.valueOf(command[3]),
                additionalMetadata, file)).getMessage());
    }

    @Override
    protected String commandDescription() {
        return "Upload a Pet image";
    }

    @Override
    protected String commandExample() {
        return "~post|pet|image|petID|additionalMetadata|file~\n" +
                "post|pet|image|85262|MyCatPhoto|008.jpg\n";
    }

    @Override
    protected int getNumberCommands() {
        return 6;
    }
    
}
