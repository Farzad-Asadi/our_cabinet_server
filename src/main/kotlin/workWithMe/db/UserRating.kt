package workWithMe.db

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption
import workWithMe.db.Customers.nullable


object UserRatings : IntIdTable() {

    val userHistory = varchar("userHistory", 100).default("userHistory")
    val pointToCustomer = reference("pointToCustomer",Customers, onDelete = ReferenceOption.CASCADE,onUpdate = ReferenceOption.CASCADE).nullable()
    val pointToExhibitor = reference("pointToExhibitor",Exhibitors, onDelete = ReferenceOption.CASCADE,onUpdate = ReferenceOption.CASCADE).nullable()
    val pointToDesigner = reference("pointToDesigner",Designers, onDelete = ReferenceOption.CASCADE,onUpdate = ReferenceOption.CASCADE).nullable()
    val pointToCabinetMaker = reference("pointToCabinetMaker",CabinetMakers, onDelete = ReferenceOption.CASCADE,onUpdate = ReferenceOption.CASCADE).nullable()
    val pointToCuttingWork = reference("pointToCuttingWork",CuttingWorks, onDelete = ReferenceOption.CASCADE,onUpdate = ReferenceOption.CASCADE).nullable()
    val pointToAssembler = reference("pointToAssembler",Assemblers, onDelete = ReferenceOption.CASCADE,onUpdate = ReferenceOption.CASCADE).nullable()
    val pointToInstaller = reference("pointToInstaller",Installers, onDelete = ReferenceOption.CASCADE,onUpdate = ReferenceOption.CASCADE).nullable()
    val pointToTransporter = reference("pointToTransporter",Transporters, onDelete = ReferenceOption.CASCADE,onUpdate = ReferenceOption.CASCADE).nullable()
    val pointToSellingAccessories = reference("pointToSellingAccessories",SellingAccessoriess, onDelete = ReferenceOption.CASCADE,onUpdate = ReferenceOption.CASCADE).nullable()
}

class UserRating(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserRating>(UserRatings)

    val iD : Int
        get() = id.value
    val userHistory by UserRatings.userHistory
    var pointToCustomer by Customer optionalReferencedOn UserRatings.pointToCustomer
    var pointToExhibitor by Exhibitor optionalReferencedOn UserRatings.pointToExhibitor
    var pointToDesigner by Designer optionalReferencedOn UserRatings.pointToDesigner
    var pointToCabinetMaker by CabinetMaker optionalReferencedOn UserRatings.pointToCabinetMaker
    var pointToCuttingWork by CuttingWork optionalReferencedOn UserRatings.pointToCuttingWork
    var pointToAssembler by Assembler optionalReferencedOn UserRatings.pointToAssembler
    var pointToInstaller by Installer optionalReferencedOn UserRatings.pointToInstaller
    var pointToTransporter by Transporter optionalReferencedOn UserRatings.pointToTransporter
    var pointToSellingAccessories by SellingAccessories optionalReferencedOn UserRatings.pointToSellingAccessories

}