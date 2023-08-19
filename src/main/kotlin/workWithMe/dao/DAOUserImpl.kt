package com.example.dao


//class DAOUserImpl() : DAOUser {
//
//    private val logger = KtorSimpleLogger("DAOUserImpl")
//
//
//    override suspend fun changeUserRelationToUserRelationDto(userRelationList: List<UserRelation>): List<UserRelationDto?> {
//        return dbQuery {
//            val userRelationDtoList = mutableListOf<UserRelationDto?>()
//
//            userRelationList.map { userRelation ->
//                val userRelationDto = UserRelationDto(
//                    parent = UserDto(
//                        nationalId = userRelation.parent?.nationalId,
//                        name = userRelation.parent?.name,
//                        password = userRelation.parent?.password,
//                        phone = userRelation.parent?.phone,
//                        email = userRelation.parent?.email,
//                        profilePic = userRelation.parent?.profilePic
//                    ),
//                    child = UserDto(
//                        nationalId = userRelation.child?.nationalId,
//                        name = userRelation.child?.name,
//                        password = userRelation.child?.password,
//                        phone = userRelation.child?.phone,
//                        email = userRelation.child?.email,
//                        profilePic = userRelation.child?.profilePic
//                    )
//                )
//                userRelationDtoList.add(userRelationDto)
//            }
//            userRelationDtoList
//        }
//    }
//
//    override suspend fun changeUserTaskToUserTaskDto(userTaskList: List<UserTask>): List<UserTaskDto?> {
//        return dbQuery {
//            val userTaskDtoList = mutableListOf<UserTaskDto?>()
//
//            userTaskList.map { userTask ->
//                val userTaskDto = UserTaskDto(
//                    id = userTask.id.value,
//                    taskCreatorUserDto = UserDto(
//                        nationalId = userTask.taskCreator?.nationalId,
//                        name = userTask.taskCreator?.name,
//                        password = userTask.taskCreator?.password,
//                        phone = userTask.taskCreator?.phone,
//                        email = userTask.taskCreator?.email,
//                        profilePic = userTask.taskCreator?.profilePic
//                    ),
//                    taskReceiverUserDto = UserDto(
//                        nationalId = userTask.taskReceiver?.nationalId,
//                        name = userTask.taskReceiver?.name,
//                        password = userTask.taskReceiver?.password,
//                        phone = userTask.taskReceiver?.phone,
//                        email = userTask.taskReceiver?.email,
//                        profilePic = userTask.taskReceiver?.profilePic
//                    ),
//                    title = userTask.title
//                )
//                userTaskDtoList.add(userTaskDto)
//            }
//            userTaskDtoList
//        }
//    }
//
//    override suspend fun changeEmotionToEmotionDto(emotionList: List<Emotion>): List<EmotionDto?> {
//        return dbQuery {
//            val emotionDtoList = mutableListOf<EmotionDto?>()
//
//            emotionList.map { emotion ->
//                val emotionDto = EmotionDto(
//                    id = emotion.id.value,
//                    emotionPic = emotion.emotionPic,
//                    timeOfEffect = emotion.timeOfEffect,
//                    titleEmotion = emotion.titleEmotion,
//                    emotionOf = UserDto(
//                        nationalId = emotion.emotionOf?.nationalId,
//                        name = emotion.emotionOf?.name,
//                        password = emotion.emotionOf?.password,
//                        phone = emotion.emotionOf?.phone,
//                        email = emotion.emotionOf?.email,
//                        profilePic = emotion.emotionOf?.profilePic
//                    )
//
//                )
//                emotionDtoList.add(emotionDto)
//            }
//            emotionDtoList
//        }
//    }
//
//
//
//    override suspend fun changeUserToUserDto(user: User): UserDto {
//        return dbQuery {
//
//            val userRelationParentOfList = user.parent.map { it }
//            val parentOf = changeUserRelationToUserRelationDto(userRelationParentOfList)
//
//            val userRelationChildOfList = user.child.map { it }
//            val childOf = changeUserRelationToUserRelationDto(userRelationChildOfList)
//
//            val userTaskTaskCreatedOfList = user.taskCreated.map { it }
//            val taskCreatedOf = changeUserTaskToUserTaskDto(userTaskTaskCreatedOfList)
//
//            val userTaskTaskReceivedOfList = user.taskCreated.map { it }
//            val taskReceivedOf = changeUserTaskToUserTaskDto(userTaskTaskReceivedOfList)
//
//            val emotionEmotionOfList = user.emotion.map { it }
//            val emotionOf = changeEmotionToEmotionDto(emotionEmotionOfList)
//
//            val userDto = UserDto(
//                nationalId = user.nationalId,
//                name = user.name,
//                password = user.password,
//                phone = user.phone,
//                email = user.email,
//                profilePic = user.profilePic,
//                parentOf = parentOf,
//                childOf = childOf,
//                taskCreatedOf = taskCreatedOf,
//                taskReceivedOf = taskReceivedOf,
//                emotionOf = emotionOf
//            )
//            userDto
//        }
//    }
//
//    override suspend fun findUserParentList(user: User): List<User?> {
//        return dbQuery {
//            val userList = mutableListOf<User?>()
//
//            val userRelationIterable = user.child
//            val userRelation = userRelationIterable.map { it }
//            userRelation.map {
//                val userParent = it.parent
//                userList.add(userParent)
//            }
//            userList
//        }
//    }
//
//    override suspend fun findUserChildrenList(user: User): List<User?> {
//        return dbQuery {
//            val userList = mutableListOf<User?>()
//
//            val userRelationIterable = user.parent
//            val userRelation = userRelationIterable.map { it }
//            userRelation.map {
//                val userParent = it.child
//                userList.add(userParent)
//            }
//            userList
//        }
//    }
//
//    override suspend fun findAllUserDto(): List<UserDto?> {
//        return dbQuery {
//            val userDtoList = mutableListOf<UserDto?>()
//            val userListIterable = User.all()
//            val userList = userListIterable.map { it }
//            userList.map {
//                val userDto = changeUserToUserDto(it)
//                userDtoList.add(userDto)
//            }
//
//            userDtoList
//        }
//
//
//    }
//
//    override suspend fun findUserByNationalId(userNationalId: Int): User? {
//        return dbQuery {
//            val userIterable = User.find { Users.nationalId eq userNationalId }
//            val user = userIterable.map { it }.firstOrNull()
//
//            user
//        }
//    }
//
//    override suspend fun findUserDtoByNationalId(userNationalId: Int): UserDto {
//        return dbQuery {
//            val userIterable = User.find { Users.nationalId eq userNationalId }
//            val user = userIterable.map { it }.firstOrNull()
//            val userDto = UserDto(
//                nationalId = user?.nationalId,
//                name = user?.name,
//                password = user?.password,
//                phone = user?.phone,
//                email = user?.email,
//                profilePic = user?.profilePic,
//            )
//
//            userDto
//        }
//    }
//
//    override suspend fun addNewUser(userDto: UserDto): User {
//
//        return dbQuery {
//
//            val newUser = User.new {
//                nationalId = userDto.nationalId
//                name = userDto.name
//                password = userDto.password
//                phone = userDto.phone
//                email = userDto.email
//                profilePic = userDto.profilePic
//            }
//            newUser.flush()
//            newUser
//        }
//
//    }
//
//    override suspend fun addNewRelation(parentOfUserDto: UserDto, thisUserDto: UserDto) {
//        dbQuery {
//
//
//            val parentOfUser = parentOfUserDto.nationalId?.let { findUserByNationalId(it) }
//            val thisUser = thisUserDto.nationalId?.let { findUserByNationalId(it) }
//
//            // چک کردن وجود رکورد مشابه
//            val existingRelation1 = UserRelation.find {
//                (UserRelations.parent eq parentOfUser?.id) and (UserRelations.child eq thisUser?.id)
//            }.firstOrNull()
//
//
//
//            if (existingRelation1 == null) {
//                val newRelation = UserRelation.new {
//                    parent = parentOfUser
//                    child = thisUser
//
//                }
//                newRelation.flush()
//            }
//        }
//    }
//
//    override suspend fun editUser(userDto: UserDto): Boolean {
//        return dbQuery {
//            logger.info("editUser bigint")
//
//            val userToEdit = User.find { Users.nationalId eq userDto.nationalId }.map { it }.firstOrNull()
//
//            if (userToEdit?.nationalId != null) {
//                userToEdit.name = userDto.name ?: userToEdit.name
//                userToEdit.password = userDto.password ?: userToEdit.password
//                userToEdit.phone = userDto.phone ?: userToEdit.phone
//                userToEdit.email = userDto.email ?: userToEdit.email
//                userToEdit.profilePic = userDto.profilePic ?: userToEdit.profilePic
//
//
////                //delete old relations
////                val beforeUserParentRelationIterable = UserRelation.find { UserRelations.parent eq userToEdit.id }
////                val beforeUserParentRelation = beforeUserParentRelationIterable.map { it }
////                beforeUserParentRelation.map {
////                    it.delete()
////                }
////
//////                val idOfParentRelationList = beforeUserParentRelation.map { it.id }
//////                idOfParentRelationList.forEach {
//////                    val oldParentRelation = UserRelation.findById(it.toString().toInt())
//////                    oldParentRelation?.delete()
//////                    oldParentRelation?.flush()
//////
//////                }
////                val beforeUserChildRelationIterable = UserRelation.find { UserRelations.child eq userToEdit.id }
////                val beforeUserChildRelation = beforeUserChildRelationIterable.map { it }
////                beforeUserChildRelation.map {
////                    it.delete()
////                }
////                val idOfChildRelationList = beforeUserChildRelation.map { it.id }
////                idOfChildRelationList.forEach {
////                    val oldChildRelation = UserRelation.findById(it.toString().toInt())
////                    oldChildRelation?.delete()
////                    oldChildRelation?.flush()
////                }
//
//
//                //Create new relation
//
////                addNewRelationParent(userDto.parentOf, userDto.childOf)
//
//            }
//            true
//        }
//    }
//
//    override suspend fun deleteUser(userNationalId: Int): Boolean {
//
//        return dbQuery {
//            val user = findUserByNationalId(userNationalId)
//            if (user?.nationalId != null) {
//                user.delete()
//                user.flush()
//                return@dbQuery true
//            } else {
//                return@dbQuery false
//            }
//        }
//    }
//
//
//
//
//
//    override suspend fun addNewTask(userTaskDto: UserTaskDto): UserTask {
//        val taskCreatorUser = userTaskDto.taskCreatorUserDto?.nationalId?.let { findUserByNationalId(it) }
//        val taskReceiverUser = userTaskDto.taskReceiverUserDto?.nationalId?.let { findUserByNationalId(it) }
//        return dbQuery {
//
//            val newTask =
//                UserTask.new {
//                    taskCreator = taskCreatorUser
//                    taskReceiver = taskReceiverUser
//                    title = userTaskDto.title
//                }
//            newTask.flush()
//            newTask
//        }
//    }
//
//    override suspend fun editTask(userTaskDto: UserTaskDto): Boolean {
//        val taskCreatorUser = userTaskDto.taskCreatorUserDto?.nationalId?.let { findUserByNationalId(it) }
//        val taskReceiverUser = userTaskDto.taskReceiverUserDto?.nationalId?.let { findUserByNationalId(it) }
//        return dbQuery {
//
//            val taskToEdit = UserTask.find { UserTasks.id eq userTaskDto.id }.map { it }.firstOrNull()
//
//            if (taskToEdit?.id != null) {
//                taskToEdit.taskCreator = taskCreatorUser ?: taskToEdit.taskCreator
//                taskToEdit.taskReceiver = taskReceiverUser ?: taskToEdit.taskReceiver
//                taskToEdit.title = userTaskDto.title ?: taskToEdit.title
//
//            }
//            true
//        }
//    }
//
//    override suspend fun deleteTask(userTaskDto: UserTaskDto): Boolean {
//        return dbQuery {
//            val taskToDelete = UserTask.find { UserTasks.id eq userTaskDto.id }.map { it }.firstOrNull()
//            logger.info("userTaskDto for delete is - > $taskToDelete")
//            if (taskToDelete?.id != null) {
//                taskToDelete.delete()
//                taskToDelete.flush()
//                return@dbQuery true
//            } else {
//                return@dbQuery false
//            }
//        }
//    }
//
//    override suspend fun deleteTask(userTask: UserTask): Boolean {
//        return dbQuery {
//            val taskToDelete = UserTask.find { UserTasks.id eq userTask.id }.map { it }.firstOrNull()
//            if (taskToDelete?.id != null) {
//                taskToDelete.delete()
//                taskToDelete.flush()
//                return@dbQuery true
//            } else {
//                return@dbQuery false
//            }
//        }
//    }
//
//    override suspend fun deleteTask(id: Int): Boolean {
//        return dbQuery {
//            val taskToDelete = UserTask.find { UserTasks.id eq id }.map { it }.firstOrNull()
//            if (taskToDelete?.id != null) {
//                taskToDelete.delete()
//                taskToDelete.flush()
//                return@dbQuery true
//            } else {
//                return@dbQuery false
//            }
//        }
//    }
//
//    override suspend fun findTaskByUserCreated(creatorNationalId: Int): List<UserTask> {
//        return dbQuery {
//            val userTask = mutableListOf<UserTask>()
//            val userIterable = User.find { Users.nationalId eq creatorNationalId }
//            val user = userIterable.map { it }.firstOrNull()
//            val taskByUserCreatedIterable = user?.taskCreated
//            val allUserTask = taskByUserCreatedIterable?.map { it }
//            allUserTask?.map {
//                if (it.taskCreator?.nationalId == creatorNationalId) {
//                    userTask.add(it)
//                }
//            }
//
//            userTask
//        }
//    }
//
//    override suspend fun findTaskByUsingNationalId(usingNationalId: Int): List<UserTask> {
//        return dbQuery {
//            val userTask = mutableListOf<UserTask>()
//            val userIterable = User.find { Users.nationalId eq usingNationalId }
//            val user = userIterable.map { it }.firstOrNull()
//            val taskByUserCreatedIterable = user?.taskReceived
//            val allUserTask = taskByUserCreatedIterable?.map { it }
//            allUserTask?.map {
//                if (it.taskReceiver?.nationalId == usingNationalId) {
//                    userTask.add(it)
//                }
//            }
//
//            userTask
//        }
//    }
//
//
//
//
//    override suspend fun addNewEmotion(emotionDto: EmotionDto): Emotion {
//        logger.info("emotionDto is -->$emotionDto")
//        val user = emotionDto.emotionOf?.nationalId?.let { findUserByNationalId(it) }
//        logger.info("user is -->$user")
//        return dbQuery {
//
//            val emotion =
//                Emotion.new {
//                    emotionPic = emotionDto.emotionPic
//                    timeOfEffect = emotionDto.timeOfEffect
//                    titleEmotion = emotionDto.titleEmotion
//                    emotionOf = user
//                }
//            logger.info("emotion is -->$emotion")
//            emotion.flush()
//            emotion
//        }
//    }
//    override suspend fun deleteEmotion(emotionDto: EmotionDto): Boolean {
//        return dbQuery {
//            val emotionToDelete = Emotion.find { Emotions.id eq emotionDto.id }.map { it }.firstOrNull()
//            if (emotionToDelete?.id != null) {
//                emotionToDelete.delete()
//                emotionToDelete.flush()
//                return@dbQuery true
//            } else {
//                return@dbQuery false
//            }
//        }
//    }
//
//
//
//
//}
//
//val dao: DAOUser = DAOUserImpl().apply {
//
//    runBlocking {
//        if (findAllUserDto().isEmpty()) {
//
//
//
//            val userDto1 = UserDto(111, "narmila", "1234", "0919", "gmail1", "3")
//
//            val userDto2 = UserDto(222, "farzad", "1234", "0918", "gmail2", "1")
//
//            val userDto3 = UserDto(333, "ardi", "1234", "0935", "gmail3", "-3")
//
//
//
//            addNewUser(userDto1)
//            addNewUser(userDto2)
//            addNewUser(userDto3)
//            addNewRelation(userDto1,userDto2)
//            addNewRelation(userDto1,userDto2)
//            addNewRelation(userDto1,userDto3)
//            addNewRelation(userDto1,userDto3)
//        }
//    }
//}




