package ua.goit.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category implements BaseEntity<Long> {

    private static final long serialVersionUID = -1722275698114863536L;

    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private String name;
}
