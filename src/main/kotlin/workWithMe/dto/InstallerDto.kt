package workWithMe.dto

import kotlinx.serialization.Serializable

@Serializable
data class InstallerDto(
    val iD : Int? = null,
    val nationalId : String = "nationalId",
    val name : String = "name",
    val password : String = "password",
    val phone : String = "phone",
    val email : String = "email",
    val homeAddress : String = "homeAddress",
    val businessAddress : String = "businessAddress",
    val creditType : String = "creditType",
    val dateOfRegistration : String = "dateOfRegistration",
    val pointToCase: CaseDto? = null,   // به رکوردی از جدول case اشاره دارد
    val referrersOnUserStorage : UserStorageDto? = null,// ستون pointToInstaller جدول UserStorageDto به این ستون اشاره دارد
    var referrersOnUserRating : UserRatingDto? = null,// ستون pointToInstaller جدول UserRatingDto به این ستون اشاره دارد


)
