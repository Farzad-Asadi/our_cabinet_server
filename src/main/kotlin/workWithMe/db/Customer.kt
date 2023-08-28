package workWithMe.db

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption


object Customers : IntIdTable() {

    val nationalId = varchar("nationalId", 10).default("nationalId")
    val name = varchar("name", 40).default("name")
    val password = varchar("password", 10).default("password")
    val phone = varchar("phone", 14).default("phone")
    val email = varchar("email", 40).default("email")
    val homeAddress = varchar("homeAddress", 300).default("homeAddress")
    val businessAddress = varchar("businessAddress", 300).default("businessAddress")
    val creditType = varchar("creditType", 50).default("creditType")
    val dateOfRegistration = varchar("dateOfRegistration", 40).default("dateOfRegistration")
    var pointToCase = reference("pointToCase",Cases, onDelete = ReferenceOption.CASCADE,onUpdate = ReferenceOption.CASCADE).nullable()
}

class Customer(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Customer>(Customers)

    val iD : Int
        get() = id.value
    var nationalId by Customers.nationalId
    var name by Customers.name
    var password by Customers.password
    var phone by Customers.phone
    var email by Customers.email
    var homeAddress by Customers.homeAddress
    var businessAddress by Customers.businessAddress
    var creditType by Customers.creditType
    var dateOfRegistration by Customers.dateOfRegistration
    var pointToCase by Case optionalReferencedOn Customers.pointToCase
    val referrersOnUserStorage by UserStorage optionalReferrersOn  UserStorages.pointToCustomer
    val referrersOnUserRating by UserRating optionalReferrersOn  UserRatings.pointToCustomer

}