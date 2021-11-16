package ua.goit.service.retrofit;

import ua.goit.model.ApiResponse;
import ua.goit.model.Pet;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import java.util.List;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface RetrofitPet {
    
    @POST("pet")
    @Headers({"ContentType-Type: application/json"})
    Call<Pet> create(@Body Pet pet);

    @PUT("pet")
    @Headers({"Content-Type: application/json"})
    Call<Pet> update(@Body Pet pet);
    
    @GET("pet/{petId}")
    @Headers({"Content-Type: application/json"})
    Call<Pet> findById(@Path("petId") Long petId);
    
    @DELETE("pet/{petId}")
    @Headers({"Content-Type: application/json"})
    Call<ApiResponse> deleteById(@Path("petId") Long id);
    
    @FormUrlEncoded
    @POST("pet/{petId}")
    @Headers({"Content-Type: application/json"})
    Call<ApiResponse> updateById(@Path("petId") Long id,
            @Field("name") String name,
            @Field("status") String status);
        
    @Multipart
    @POST("pet/{petId}/uploadImage")
    @Headers({"ContentType-Type: multipart/form-data"})
    Call<ApiResponse> uploadImage(@Path("petId") Long id,
            @Part MultipartBody.Part additionalMetadata,
            @Part MultipartBody.Part filePart);

    @GET("pet/findByStatus")
    @Headers({"Content-Type: application/json"})
    Call<List<Pet>> getByStatus(@Query("status") String status);
    
}
