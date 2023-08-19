package workWithMe.db

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption


object Users : IntIdTable() {
    val nationalId = integer("nationalId").nullable()
    val name = varchar("name", 30).nullable()
    val password = varchar("password", 15).nullable()
    val phone = varchar("phone", 15).nullable()
    val email = varchar("email", 40).uniqueIndex().nullable()
    val profilePic = varchar("profilePic", 20).nullable()
}

class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(Users)

    var nationalId by Users.nationalId
    var name by Users.name
    var password by Users.password
    var phone by Users.phone
    var email by Users.email
    var profilePic by Users.profilePic
    val parent by UserRelation optionalReferrersOn  UserRelations.parent
    val child by UserRelation optionalReferrersOn  UserRelations.child
    val taskCreated by UserTask optionalReferrersOn  UserTasks.taskCreator
    val taskReceived by UserTask optionalReferrersOn  UserTasks.taskReceiver
    val emotion by Emotion optionalReferrersOn  Emotions.emotionOf
}



object UserRelations : IntIdTable() {
    var parent = reference("parent",Users, onDelete = ReferenceOption.CASCADE,onUpdate = ReferenceOption.CASCADE).nullable()
    var child = reference("child",Users, onDelete = ReferenceOption.CASCADE,onUpdate = ReferenceOption.CASCADE).nullable()
}
class UserRelation(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserRelation>(UserRelations)

    var parent by User optionalReferencedOn UserRelations.parent
    var child by User optionalReferencedOn UserRelations.child
}





object UserTasks : IntIdTable() {
    val taskCreator = reference("taskCreator",Users, onDelete = ReferenceOption.CASCADE,onUpdate = ReferenceOption.CASCADE).nullable()
    val taskReceiver = reference("taskReceiver",Users, onDelete = ReferenceOption.CASCADE,onUpdate = ReferenceOption.CASCADE).nullable()
    val title = varchar("title", 100).nullable()
}
class UserTask(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserTask>(UserTasks)

    val entityId: Int
        get() = id.value
    var taskCreator by User optionalReferencedOn UserTasks.taskCreator
    var taskReceiver by User optionalReferencedOn UserTasks.taskReceiver
    var title by UserTasks.title

}


object Emotions : IntIdTable() {
    val emotionPic= varchar("emotionPic", 20).nullable()
    val timeOfEffect= varchar("timeOfEffect", 20).nullable()
    val titleEmotion = varchar("titleEmotion", 100).nullable()
    val emotionOf = reference("emotionOf",Users, onDelete = ReferenceOption.CASCADE,onUpdate = ReferenceOption.CASCADE).nullable()
}
class Emotion(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Emotion>(Emotions)

    val entityId: Int
        get() = id.value
    var emotionPic by Emotions.emotionPic
    var timeOfEffect by Emotions.timeOfEffect
    var titleEmotion by Emotions.titleEmotion
    var emotionOf by User optionalReferencedOn Emotions.emotionOf

}
