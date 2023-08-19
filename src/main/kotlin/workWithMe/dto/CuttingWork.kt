package workWithMe.dto

import kotlinx.serialization.Serializable

@Serializable
data class CuttingWork(
    val id : String,
    val nationalId : String = "nationalId",
    val name : String = "name",
    val password : String = "password",
    val phone : String = "phone",
    val email : String = "email",
    val homeAddress : String = "homeAddress",
    val businessAddress : String = "businessAddress",
    val creditType : String = "creditType",
    val dateOfRegistration : String = "dateOfRegistration",
    val userStorage : UserStorage? = null,
    var userRating : UserRating? = null,

    )
