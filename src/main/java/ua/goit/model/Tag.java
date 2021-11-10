package ua.goit.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tag implements BaseEntity<Long> {

    private static final long serialVersionUID = -1450464305233433874L;

    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private String name;
}
