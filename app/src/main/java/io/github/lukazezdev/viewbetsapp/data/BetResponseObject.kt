package io.github.lukazezdev.viewbetsapp.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BetResponseObject(
    @SerialName("title") val type: String,
    @SerialName("sellin") val sellIn: Int,
    @SerialName("odds") val odds: Int,
    @SerialName("imageUrl") val imageUrl: String
)
