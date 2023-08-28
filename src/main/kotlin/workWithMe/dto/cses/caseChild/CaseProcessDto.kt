package workWithMe.dto.cses.caseChild

import kotlinx.serialization.Serializable
import workWithMe.dto.cses.CaseDto

@Serializable
data class CaseProcessDto(
    val iD : Int? = null,
    val pointToCase: CaseDto? = null,   // به رکوردی از جدول case اشاره دارد

    )
