package ua.goit.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements BaseEntity<Long> {

    private static final long serialVersionUID = 5093217570389294027L;

    @SerializedName("id")
    private Long id;

    @SerializedName("username")
    private String userName;

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("lastName")
    private String lastName;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("phone")
    private String phone;

    @SerializedName("userStatus")
    private Integer userStatus;

    public User(String ... parameters) {
        this.id = Long.valueOf(parameters[0]);
        this.userName = parameters[1];
        this.firstName = parameters[2];
        this.lastName = parameters[3];
        this.email = parameters[4];
        this.password = parameters[5];
        this.phone = parameters[6];
        this.userStatus = Integer.valueOf(parameters[7]);
    }
}
