package workWithMe.db

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption


object Assemblers : IntIdTable() {

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

class Assembler(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Assembler>(Assemblers)

    val iD : Int
        get() = id.value
    var nationalId by Assemblers.nationalId
    var name by Assemblers.name
    var password by Assemblers.password
    var phone by Assemblers.phone
    var email by Assemblers.email
    var homeAddress by Assemblers.homeAddress
    var businessAddress by Assemblers.businessAddress
    var creditType by Assemblers.creditType
    var dateOfRegistration by Assemblers.dateOfRegistration
    var pointToCase by Case optionalReferencedOn Assemblers.pointToCase
    val referrersOnUserStorage by UserStorage optionalReferrersOn  UserStorages.pointToCustomer
    val referrersOnUserRating by UserRating optionalReferrersOn  UserRatings.pointToCustomer

}