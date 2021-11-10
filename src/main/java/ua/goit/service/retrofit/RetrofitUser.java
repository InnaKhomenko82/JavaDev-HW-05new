package ua.goit.service.retrofit;

import ua.goit.model.ApiResponse;
import ua.goit.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import java.util.List;

public interface RetrofitUser {
    
    @POST("user")
    @Headers({"ContentType-Type: application/json"})
    Call<User> create(@Body User user);
    
    @GET("user/{userName}")
    @Headers({"ContentType-Type: application/json"})
    Call<User> getUserByName(@Path("userName") String userName);

    @PUT("user/{userName}")
    @Headers({"ContentType-Type: application/json"})
    Call<User> updateByName(@Body User user, @Path("userName") String userName);

    @DELETE("user/{userName}")
    @Headers({"ContentType-Type: application/json"})
    Call<ApiResponse> deleteByName(@Path("userName") String userName);

    @GET("user/login")
    @Headers({"ContentType-Type: application/json"})
    Call<ApiResponse> login(@Query("userName") String userName, @Query("password") String password);

    @GET("user/logout")
    @Headers({"ContentType-Type: application/json"})
    Call<ApiResponse> logout();
    
    @POST("user/createWithList")
    @Headers({"ContentType-Type: application/json"})
    Call<ApiResponse> createWithList(@Body List<User> users);

//    @POST("user/createWithArray")
//    @Headers({"ContentType-Type: application/json"})
//    Call<ApiResponse> createWithArray(@Body User[] users);

}
