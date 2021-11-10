package ua.goit.util;

import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.goit.exception.HttpException;

public class Retrofit {

    private static final String BASE_URL = PropertiesLoader.getProperty("url");

    public static <T> T createClient(Class<T> clientClass) {
        return createClient(BASE_URL, clientClass);
    }

    private static <T> T createClient(String apiUrl, Class<T> clientClass) {
        return new retrofit2.Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(clientClass);
    }

    @SneakyThrows
    public static <T> T execute(Call<T> call) {
        Response<T> response = call.execute();
        if (response.isSuccessful()) return response.body();
        else throw new HttpException(response.code(), response.errorBody().string());
    }

}
