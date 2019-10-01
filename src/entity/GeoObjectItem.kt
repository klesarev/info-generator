package entity

import com.google.gson.annotations.SerializedName

data class GeoObjectItem (
    @SerializedName("text")
    val text: String,
    @SerializedName("kind")
    val kind: String
)