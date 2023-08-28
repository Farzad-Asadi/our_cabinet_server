package workWithMe.db

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import java.util.UUID


object Cases : IntIdTable() {
    val caseId = varchar("caseId", 10).nullable()

}

class Case(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Case>(Cases)

    val iD : Int
        get() = id.value
    var caseId by Cases.caseId
    val referrersOnCustomer by Customer optionalReferrersOn  Customers.pointToCase


}

