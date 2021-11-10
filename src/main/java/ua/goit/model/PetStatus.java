package ua.goit.model;

import com.google.gson.annotations.SerializedName;

public enum PetStatus {
    @SerializedName("available")
    AVAILABLE,
    @SerializedName("pending")
    PENDING,
    @SerializedName("sold")
    SOLD;
}
