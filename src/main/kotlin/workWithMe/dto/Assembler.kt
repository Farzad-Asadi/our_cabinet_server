package ir.workwithme.our_cabinets_client.model.dto

import kotlinx.serialization.Serializable
import workWithMe.dto.UserRating
import workWithMe.dto.UserStorage

@Serializable
data class Assembler(
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
