package net.ijichi.zaifvirtualcurrency.api.model.entity

data class Currency(
    val isToken: Boolean,
    val id: Int,
    val name: String,
    val tokenId: Int
)

