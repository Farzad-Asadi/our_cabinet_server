package workWithMe.db

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption


object SellingAccessoriess : IntIdTable() {

    val nationalId = varchar("nationalId", 100).default("nationalId")
    val name = varchar("name", 100).default("name")
    val password = varchar("password", 100).default("password")
    val phone = varchar("phone", 100).default("phone")
    val email = varchar("email", 100).default("email")
    val homeAddress = varchar("homeAddress", 100).default("homeAddress")
    val businessAddress = varchar("businessAddress", 100).default("businessAddress")
    val creditType = varchar("creditType", 100).default("creditType")
    val dateOfRegistration = varchar("dateOfRegistration", 100).default("dateOfRegistration")
    var pointToCase = reference("pointToCase",Cases, onDelete = ReferenceOption.CASCADE,onUpdate = ReferenceOption.CASCADE).nullable()
}

class SellingAccessories(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<SellingAccessories>(SellingAccessoriess)

    val iD : Int
        get() = id.value
    var nationalId by SellingAccessoriess.nationalId
    var name by SellingAccessoriess.name
    var password by SellingAccessoriess.password
    var phone by SellingAccessoriess.phone
    var email by SellingAccessoriess.email
    var homeAddress by SellingAccessoriess.homeAddress
    var businessAddress by SellingAccessoriess.businessAddress
    var creditType by SellingAccessoriess.creditType
    var dateOfRegistration by SellingAccessoriess.dateOfRegistration
    var pointToCase by Case optionalReferencedOn SellingAccessoriess.pointToCase
    val referrersOnUserStorage by UserStorage optionalReferrersOn  UserStorages.pointToCustomer
    val referrersOnUserRating by UserRating optionalReferrersOn  UserRatings.pointToCustomer

}