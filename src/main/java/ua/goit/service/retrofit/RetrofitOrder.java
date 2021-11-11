package ua.goit.service.retrofit;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ua.goit.model.ApiResponse;
import ua.goit.model.Order;

public interface RetrofitOrder {

    @POST("store/order")
    @Headers({"ContentType-Type: application/json"})
    Call<Order> create(@Body Order order);

    @GET("store/order/{orderId}")
    @Headers({"ContentType-Type: application/json"})
    Call<Order> findById(@Path("orderId") Long orderId);

    @DELETE("store/order/{orderId}")
    @Headers({"Content-Type: application/json"})
    Call<ApiResponse> deleteById(@Path("orderId") Long id);
    
    @GET("store/inventory")
    @Headers({"ContentType-Type: application/json"})
    Call<Map<String, Integer>> getInventory();

}
