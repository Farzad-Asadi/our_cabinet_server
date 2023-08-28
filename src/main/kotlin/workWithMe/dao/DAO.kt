package workWithMe.dao

import workWithMe.db.Case
import workWithMe.db.Customer
import workWithMe.dto.cses.CaseDto
import workWithMe.dto.cses.caseChild.user.CustomerDto


interface DAO {


    //Case
    suspend fun changeCaseToCaseDto(case: Case): CaseDto
    suspend fun findAllCaseDto(): List<CaseDto?>
    suspend fun findCaseByCaseId(caseId: String): Case?
    suspend fun addNewCase(): Case
    suspend fun addNewCase(caseDto: CaseDto): Case
    suspend fun deleteCase(caseDto: CaseDto): Boolean
    suspend fun editCase(caseDto: CaseDto): Case?


    //Customer
    suspend fun changeCustomerToCustomerDto(customer: Customer): CustomerDto
    suspend fun findAllCustomerDto(): List<CustomerDto?>
    suspend fun findCustomerByNationalId(nationalId: String): Customer?
    suspend fun addNewCustomer(customerDto: CustomerDto, case: Case? = null): Customer
    suspend fun deleteCustomer(customerDto: CustomerDto): Boolean
    suspend fun editCustomer(customerDto: CustomerDto): Customer?

}

