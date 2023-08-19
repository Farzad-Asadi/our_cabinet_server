package workWithMe.dto

import ir.workwithme.our_cabinets_client.model.dto.*
import kotlinx.serialization.Serializable

@Serializable
data class Cases(
    val id : String,
    val customer : Customer? = null,
    val exhibitor : List<Exhibitor>? = null,
    val designer : List<Designer>? = null,
    val cabinetMaker : List<CabinetMaker>? = null,
    val cuttingWork : List<CuttingWork>? = null,
    val assembler : List<Assembler>? = null,
    val installer : List<Installer>? = null,
    val transporter : List<Transporter>? = null,
    val sellingAccessories : List<SellingAccessories>? = null,
    val order : Order? = null,
    val contract : Contract? = null,
    val caseProcess : CaseProcess? = null,
    val caseStorage : CaseStorage? = null,

    )










