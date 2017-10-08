package io.github.legosteen11.pdoklocatieserverclient.response

import com.google.gson.annotations.SerializedName

enum class ObjectType {
    @SerializedName("gemeente")
    GEMEENTE,
    @SerializedName("woonplaats")
    WOONPLAATS,
    @SerializedName("weg")
    WEG,
    @SerializedName("postcode")
    POSTCODE,
    @SerializedName("adres")
    ADRES,
    @SerializedName("perceel")
    PERCEEL
}