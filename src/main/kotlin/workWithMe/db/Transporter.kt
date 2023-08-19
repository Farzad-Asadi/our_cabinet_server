package workWithMe.db

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption


object Transporters : IntIdTable() {

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

class Transporter(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Transporter>(Transporters)

    val iD : Int
        get() = id.value
    var nationalId by Transporters.nationalId
    var name by Transporters.name
    var password by Transporters.password
    var phone by Transporters.phone
    var email by Transporters.email
    var homeAddress by Transporters.homeAddress
    var businessAddress by Transporters.businessAddress
    var creditType by Transporters.creditType
    var dateOfRegistration by Transporters.dateOfRegistration
    var pointToCase by Case optionalReferencedOn Transporters.pointToCase
    val referrersOnUserStorage by UserStorage optionalReferrersOn  UserStorages.pointToCustomer
    val referrersOnUserRating by UserRating optionalReferrersOn  UserRatings.pointToCustomer

}