package workWithMe.dto.cses.caseChild.order

import kotlinx.serialization.Serializable
import workWithMe.dto.cses.CaseDto

@Serializable
data class OrderDto(
    val iD : Int? = null,
    val pointToCase: CaseDto? = null,   // به رکوردی از جدول case اشاره دارد

    )
