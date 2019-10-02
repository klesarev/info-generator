package entity

import com.google.gson.annotations.SerializedName

data class GeoObject (
    @SerializedName("text")
    val text: String,
    @SerializedName("kind")
    val kind: String
)