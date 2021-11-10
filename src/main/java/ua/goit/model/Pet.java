package ua.goit.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet implements BaseEntity<Long> {

    private static final long serialVersionUID = -2869640630728594239L;

    @SerializedName("id")
    private Long id;

    @SerializedName("category")
    private Category category;

    @SerializedName("name")
    private String name;

    @SerializedName("photoUrls")
    private String[] photoUrls;

    @SerializedName("tags")
    private Tag[] tags;

    @SerializedName("status")
    private PetStatus status;

    public Pet(String ... parameters) {
        this.id = Long.valueOf(parameters[0]);
        this.name = parameters[1];
        this.status = PetStatus.valueOf(parameters[2]);
        this.category = new Category(0L, parameters[3]);
    }

}
