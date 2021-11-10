package ua.goit.model;

import com.google.gson.annotations.SerializedName;

public enum OrderStatus {
    @SerializedName("placed")
    PLACED,
    @SerializedName("approved")
    APPROVED,
    @SerializedName("delivered")
    DELIVERED;
}
