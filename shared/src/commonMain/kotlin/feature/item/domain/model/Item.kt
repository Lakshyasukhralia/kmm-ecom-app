package feature.item.domain.model

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize

@Parcelize
data class Item(
    val id: String,
    val name: String,
    val description: String,
    val price: Float
): Parcelable