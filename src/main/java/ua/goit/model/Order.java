package ua.goit.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order implements BaseEntity<Long> {

    private static final long serialVersionUID = 3903402690623533383L;

    @SerializedName("id")
    private Long id;

    @SerializedName("petId")
    private Long petId;

    @SerializedName("quantity")
    private Integer quantity;

    @SerializedName("shipDate")
    private LocalDate shipDate;

    @SerializedName("status")
    private OrderStatus status;

    @SerializedName("complete")
    private Boolean complete;

    public Order(String... parameters) {
        this.id = Long.valueOf(parameters[0]);
        this.petId = Long.valueOf(parameters[1]);
        this.quantity = Integer.valueOf(parameters[2]);
        this.shipDate = LocalDate.parse(parameters[3]);
        this.status = OrderStatus.valueOf(parameters[4]);
        this.complete = Boolean.valueOf(parameters[5]);
    }
}
