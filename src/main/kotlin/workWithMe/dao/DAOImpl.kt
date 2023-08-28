package workWithMe.dao

import io.ktor.util.logging.*
import kotlinx.coroutines.runBlocking
import workWithMe.db.Case
import workWithMe.db.Cases
import workWithMe.db.Customer
import workWithMe.db.Customers
import workWithMe.db.DatabaseFactory.dbQuery
import workWithMe.dto.cses.CaseDto
import workWithMe.dto.cses.caseChild.user.CustomerDto
import java.util.UUID


class DAOImpl() : DAO {

    val logger = KtorSimpleLogger("DAOUserImpl")


    //Case
    override suspend fun changeCaseToCaseDto(case: Case): CaseDto {
        return dbQuery {

            val customer = case.referrersOnCustomer.map { it }.firstOrNull()
            val customerDto = customer?.let { changeCustomerToCustomerDto(it) }

            val caseDto = CaseDto(

                iD = case.iD,
                caseId = case.caseId,
                referrersOnCustomer = customerDto
            )

            caseDto
        }
    }

    override suspend fun findAllCaseDto(): List<CaseDto?> {
        return dbQuery {
            val caseDtoList = mutableListOf<CaseDto?>()
            val caseDtoIterableList = Case.all()

            val caseList = caseDtoIterableList.map { it }
            caseList.map {
                val caseDto = changeCaseToCaseDto(it)
                caseDtoList.add(caseDto)
            }

            caseDtoList
        }
    }

    override suspend fun findCaseByCaseId(caseId: String): Case? {
        return dbQuery {
            val caseIterable = Case.find { Cases.caseId eq caseId }
            val case = caseIterable.map { it }.firstOrNull()

            case
        }
    }

    override suspend fun addNewCase(): Case{
        return dbQuery {
            val newCase = Case.new {
                caseId = UUID.randomUUID().toString().substring(0, 10)
            }
            newCase.flush()
            newCase
        }
    }

    override suspend fun addNewCase(caseDto: CaseDto): Case {
        return dbQuery {
            val newCase = Case.new {
                caseId = UUID.randomUUID().toString().substring(0, 10)
            }
            newCase.flush()
            newCase
        }
    }

    override suspend fun deleteCase(caseDto: CaseDto): Boolean {
        return dbQuery {
            val case = caseDto.caseId?.let { findCaseByCaseId(it) }
            if (case?.caseId != null) {
                case.delete()
                case.flush()
                return@dbQuery true
            } else {
                return@dbQuery false
            }
        }
    }

    override suspend fun editCase(caseDto: CaseDto): Case? {
        return dbQuery {

            val caseToEdit = Case.find { Cases.caseId eq caseDto.caseId }.map { it }.firstOrNull()

            if (caseToEdit?.caseId != null) {
                caseToEdit.caseId = caseDto.caseId ?: caseToEdit.caseId

            }
            caseToEdit
        }
    }


    //Customer
    override suspend fun changeCustomerToCustomerDto(customer: Customer): CustomerDto {
        return dbQuery {

//            val pointToCase = customer.pointToCase
//            val pointToCaseDto = pointToCase?.let { changeCaseToCaseDto(it) }

            val customerDto = CustomerDto(
                nationalId = customer.nationalId,
                name = customer.name,
                password = customer.password,
                phone = customer.phone,
                email = customer.email,
                homeAddress = customer.homeAddress,
                businessAddress = customer.businessAddress,
                creditType = customer.creditType,
                dateOfRegistration = customer.dateOfRegistration,
                pointToCase = CaseDto(
                    caseId = customer.pointToCase?.caseId
                )
            )
            customerDto
        }
    }

    override suspend fun findAllCustomerDto(): List<CustomerDto?> {
        return dbQuery {
            val customerDtoList = mutableListOf<CustomerDto?>()
            val customerDtoIterableList = Customer.all()

            val customerList = customerDtoIterableList.map { it }
            customerList.map {
                val customerDto = changeCustomerToCustomerDto(it)
                customerDtoList.add(customerDto)
            }

            customerDtoList
        }
    }

    override suspend fun findCustomerByNationalId(nationalId: String): Customer? {
        return dbQuery {
            val customerIterable = Customer.find { Customers.nationalId eq nationalId }
            val customer = customerIterable.map { it }.firstOrNull()

            customer
        }
    }

    override suspend fun addNewCustomer(customerDto: CustomerDto, case:Case?): Customer {

        if (case == null){
            val pointToThisCase = customerDto.pointToCase?.caseId?.let { findCaseByCaseId(it) }
            logger.info("pointToThisCase is  --> $pointToThisCase ")

            return dbQuery {
                val newCustomer = Customer.new {
                    nationalId = customerDto.nationalId
                    name = customerDto.name
                    password = customerDto.password
                    phone = customerDto.phone
                    email = customerDto.email
                    homeAddress = customerDto.homeAddress
                    businessAddress = customerDto.businessAddress
                    creditType = customerDto.creditType
                    dateOfRegistration = customerDto.dateOfRegistration
                    pointToCase = pointToThisCase
                }
                logger.info("newCustomer is  --> $newCustomer ")
                newCustomer.flush()
                newCustomer
            }
        }else {
            return dbQuery {
                val newCustomer = Customer.new {
                    nationalId = customerDto.nationalId
                    name = customerDto.name
                    password = customerDto.password
                    phone = customerDto.phone
                    email = customerDto.email
                    homeAddress = customerDto.homeAddress
                    businessAddress = customerDto.businessAddress
                    creditType = customerDto.creditType
                    dateOfRegistration = customerDto.dateOfRegistration
                    pointToCase = case
                }
                logger.info("newCustomer is  --> $newCustomer ")
                newCustomer.flush()
                newCustomer
            }
        }



    }

    override suspend fun deleteCustomer(customerDto: CustomerDto): Boolean {
        return dbQuery {
            val customer = findCustomerByNationalId(customerDto.nationalId)
            if (customer?.nationalId != null) {
                customer.delete()
                customer.flush()
                return@dbQuery true
            } else {
                return@dbQuery false
            }
        }
    }

    override suspend fun editCustomer(customerDto: CustomerDto): Customer? {
        return dbQuery {

            val customerToEdit =
                Customer.find { Customers.nationalId eq customerDto.nationalId }.map { it }.firstOrNull()

            if (customerToEdit?.nationalId != null) {
                customerToEdit.nationalId = customerDto.nationalId ?: customerToEdit.nationalId

            }
            customerToEdit
        }
    }


}

val dao: DAO = DAOImpl().apply {

    runBlocking {
        if (findAllCaseDto().isEmpty()) {

            val case = addNewCase()
            logger.info("case is  --> $case ")


            val customerDto = CustomerDto(
                name = "narmila"
            )
            logger.info("customerDto is  --> $customerDto ")



            val newCustomer= addNewCustomer(customerDto,case)
            logger.info("newCustomer is  --> $newCustomer ")


        }
    }
}




