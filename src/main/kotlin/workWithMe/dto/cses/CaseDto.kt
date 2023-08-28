package workWithMe.dto.cses

import kotlinx.serialization.Serializable
import workWithMe.dto.cses.caseChild.CaseProcessDto
import workWithMe.dto.cses.caseChild.CaseStorageDto
import workWithMe.dto.cses.caseChild.ContractDto
import workWithMe.dto.cses.caseChild.order.OrderDto
import workWithMe.dto.cses.caseChild.user.*

@Serializable
data class CaseDto(
    val iD: Int? = null,
    val caseId: String? = null,
    val referrersOnCustomer: CustomerDto? = null,   // ستون pointToCase جدول CustomerDto به این ستون اشاره دارد
    val referrersOnExhibitor: List<ExhibitorDto>? = null,
    val referrersOnDesigner: List<DesignerDto>? = null,
    val referrersOnCabinetMaker: List<CabinetMakerDto>? = null,
    val referrersOnCuttingWork: List<CuttingWorkDto>? = null,
    val referrersOnAssembler: List<AssemblerDto>? = null,
    val referrersOnInstaller: List<InstallerDto>? = null,
    val referrersOnTransporter: List<TransporterDto>? = null,
    val referrersOnSellingAccessories: List<SellingAccessoriesDto>? = null,
    val referrersOnOrder: OrderDto? = null,
    val referrersOnContract: ContractDto? = null,
    val referrersOnCaseProcess: CaseProcessDto? = null,
    val referrersOnCaseStorage: CaseStorageDto? = null,

    )










