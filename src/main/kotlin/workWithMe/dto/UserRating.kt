package workWithMe.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserRating(
    val id : String,
    val userHistory : String = "userHistory"

)
