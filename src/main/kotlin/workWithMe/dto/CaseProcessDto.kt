package workWithMe.dto

import kotlinx.serialization.Serializable

@Serializable
data class CaseProcessDto(
    val iD : Int? = null,
    val pointToCase: CaseDto? = null,   // به رکوردی از جدول case اشاره دارد

    )
