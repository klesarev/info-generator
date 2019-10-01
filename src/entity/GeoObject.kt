package entity

import com.google.gson.annotations.SerializedName

data class GeoObject(
    @SerializedName("featureMember")
    val featureMember:ArrayList<GeoObjectItem>
)