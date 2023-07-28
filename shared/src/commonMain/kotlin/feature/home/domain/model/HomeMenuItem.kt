package feature.home.domain.model

import Screen

data class HomeMenuItem(
    val id: String,
    val name: String,
    val screen: Screen,
    val resPath: String
)
