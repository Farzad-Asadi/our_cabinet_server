package workWithMe.dao.customer

import workWithMe.db.Case
import workWithMe.db.Customer
import workWithMe.dto.CaseDto
import workWithMe.dto.CustomerDto


interface DAOCustomer {


    //    suspend fun changeUserRelationToUserRelationDto(userRelationList : List<UserRelation>): List<UserRelationDto?>
//
//    suspend fun changeUserTaskToUserTaskDto(userTaskList: List<UserTask>): List<UserTaskDto?>
//
//    suspend fun changeEmotionToEmotionDto(emotionList: List<Emotion>): List<EmotionDto?>
//
//
//
    suspend fun changeCaseToCaseDto(case: Case): CaseDto
    suspend fun changeCustomerToCustomerDto(customer: Customer): CustomerDto
//

//
//    suspend fun findUserChildrenList(user: User): List<User?>
//
    suspend fun findAllCustomerDto(): List<CustomerDto?>
    suspend fun findAllCaseDto(): List<CaseDto?>
//
//    suspend fun findUserByNationalId(userNationalId: Int): User?
//
//    suspend fun findUserDtoByNationalId(userNationalId: Int): UserDto
//
    suspend fun addNewCase(caseDto: CaseDto): Case
    suspend fun addNewCustomer(customerDto: CustomerDto, case: Case): Customer
//
//    suspend fun addNewRelation(parentOfUserDto: UserDto, thisUserDto: UserDto)
//
//    suspend fun editUser(userDto: UserDto): Boolean
//
//    suspend fun deleteUser(userNationalId: Int): Boolean
//
//
//
//    suspend fun addNewTask(userTaskDto:UserTaskDto): UserTask
//    suspend fun editTask(userTaskDto: UserTaskDto): Boolean
//    suspend fun deleteTask(userTaskDto: UserTaskDto): Boolean
//    suspend fun deleteTask(userTask: UserTask): Boolean
//    suspend fun deleteTask(id: Int): Boolean
//    suspend fun findTaskByUserCreated(creatorNationalId: Int):List<UserTask>
//    suspend fun findTaskByUsingNationalId(usingNationalId: Int): List<UserTask>
//
//
//
//    suspend fun addNewEmotion(emotionDto: EmotionDto): Emotion
//    suspend fun deleteEmotion(emotionDto: EmotionDto): Boolean

}

