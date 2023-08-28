package workWithMe.dto.cses.caseChild.user.userChild

import kotlinx.serialization.Serializable
import workWithMe.dto.cses.caseChild.user.*

@Serializable
data class UserStorageDto(
    val iD : Int? = null,
    val pointToCustomer : CustomerDto? = null,
    val pointToExhibitor : ExhibitorDto? = null,
    val pointToDesigner : DesignerDto? = null,
    val pointToCabinetMaker : CabinetMakerDto? = null,
    val pointToCuttingWork : CuttingWorkDto? = null,
    val pointToAssembler : AssemblerDto? = null,
    val pointToInstaller : InstallerDto? = null,
    val pointToTransporter : TransporterDto? = null,
    val pointToSellingAccessories : SellingAccessoriesDto? = null,

    )
