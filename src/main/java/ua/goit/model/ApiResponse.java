package ua.goit.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse implements Serializable {

    private static final long serialVersionUID = 4635120746070598903L;

    @SerializedName("code")
    Integer code;

    @SerializedName("type")
    String type;

    @SerializedName("message")
    String message;
}
