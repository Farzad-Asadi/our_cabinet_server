package workWithMe.routes


import io.ktor.server.routing.*


fun Route.userRouting() {
    route("/user") {

//        get {       //ارسال تمامی User ها
////            call.application.environment.log.info("Hello from /api/v1!")
//            if (dao.findAllUserDto().isNotEmpty()) {
//                val allUserDto = dao.findAllUserDto()
//                call.respond(allUserDto)
//            } else {
//                call.respondText("User list are empty", status = HttpStatusCode.OK)
//
//            }
//        }
//
//        get("/{nationalId?}") {   // ارسال یک User  با nationalId
//
//            val userNationalId = call.parameters["nationalId"]?.toInt() ?: return@get call.respondText(
//                "Missing nationalId",
//                status = HttpStatusCode.BadRequest
//            )
//
//            val user = dao.findUserByNationalId(userNationalId)
//            val userDto = user?.let { it1 -> dao.changeUserToUserDto(it1) }
//            if (userDto?.nationalId == null) {
//                return@get call.respondText(
//                    "No user with nationalId $userNationalId",
//                    status = HttpStatusCode.NotFound
//                )
//            } else {
//                call.respond(userDto)
//            }
//
//
//        }
//
//        delete("/{nationalId?}") {   // پاک کردن یک User  با nationalId
//
//            val userNationalId = call.parameters["nationalId"]?.toInt() ?: return@delete call.respondText(
//                "Missing nationalId",
//                status = HttpStatusCode.BadRequest
//            )
//            val user = dao.findUserByNationalId(userNationalId)
//            if (user?.nationalId == null) {
//                return@delete call.respondText(
//                    "No user with nationalId $userNationalId",
//                    status = HttpStatusCode.NotFound
//                )
//            } else {
//                dao.deleteUser(userNationalId)
//                call.respondText(
//                    "user with nationalId $userNationalId deleted",
//                    status = HttpStatusCode.OK
//                )
//            }
//        }
//
//        post("/edit") {
//
//            val userDto = call.receive<UserDto>()
//            dao.editUser(userDto)
//            call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
//
////            val nationalId = call.parameters["id"]?.toInt() ?: return@get call.respondText(
////                "Missing id",
////                status = HttpStatusCode.BadRequest
////            )
////
////            val userParameters = call.receiveParameters()
////            val name = userParameters.getOrFail("name")
////            val password = userParameters.getOrFail("password")
////            val phone = userParameters.getOrFail("phone")
////            val email = userParameters.getOrFail("email")
////            val profilePic = userParameters.getOrFail("profilePic")
////            val parentNationalId = userParameters.getOrFail("parentNationalId")
////            val childNationalId = userParameters.getOrFail("childNationalId")
////
////
//////            call.application.environment.log.info(parentNationalId)
////            var userParent: UserDto? = null
////            userParent = if (parentNationalId != "null") {
////                dao.findUserByNationalId(parentNationalId.toInt())
////            } else {
////                val user = dao.findUserByNationalId(nationalId)
////                user?.parentOf
////            }
////
////            var userChild: UserDto? = null
////            userChild = if (childNationalId != "null") {
////                dao.findUserByNationalId(childNationalId.toInt())
////            } else {
////                val user = dao.findUserByNationalId(nationalId)
////                user?.parentOf
////            }
////            val userChildList = mutableListOf<UserDto?>()
////            userChildList.add(userChild)
////
////            call.application.environment.log.info(userChildList.toString())
////            val userDto = UserDto(nationalId, name, password, phone, email, profilePic, userParent, userChildList)
////            dao.editUser(userDto)
////            call.respondText("User edited correctly", status = HttpStatusCode.Accepted)
//        }
//
//        post {
//
//            val userDto = call.receive<UserDto>()
//            dao.addNewUser(userDto)
//            call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
//
//        }
//
//        post ("/relation"){
//
//            val userRelationDto = call.receive<UserRelationDto>()
//            userRelationDto.child?.let { it1 -> userRelationDto.parent?.let { it2 -> dao.addNewRelation(it2, it1) } }
//            call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
//
//        }
//
//
//        get("/download/{folderName?}/{fileName?}") {
//            val fileName = call.parameters["fileName"] ?: return@get call.respondText(
//                "Missing fileName",
//                status = HttpStatusCode.BadRequest
//            )
//            val folderName = call.parameters["folderName"] ?: return@get call.respondText(
//                "Missing folderName",
//                status = HttpStatusCode.BadRequest
//            )
//
//
//            val file = File("build/$folderName/$fileName")
//            call.respondFile(file)
//
//            call.application.environment.log.info(file.toString())
//        }
//
//
//
//    }
//
//    route("/task") {
//
//        post {   //add new task
//
//            val userTaskDto = call.receive<UserTaskDto>()
//            dao.addNewTask(userTaskDto)
//            call.respondText("userTask stored correctly", status = HttpStatusCode.Created)
//
//        }
//
//        post("/delete") {   //delete task
//
//            val userTaskDto = call.receive<UserTaskDto>()
//            call.application.environment.log.info("userTaskDto for delete is - > $userTaskDto")
//            dao.deleteTask(userTaskDto)
//            call.respondText("userTask delete correctly", status = HttpStatusCode.Accepted)
//
//        }
//
//    }
//
//    route("/emotion") {
//
//        post {   //add new emotion
//
//            val emotionDto = call.receive<EmotionDto>()
//            dao.addNewEmotion(emotionDto)
//            call.respondText("userTask stored correctly", status = HttpStatusCode.Created)
//
//        }
//
//        post("/delete") {   //delete emotion
//
//            val emotionDto = call.receive<EmotionDto>()
////            call.application.environment.log.info("userTaskDto for delete is - > $userTaskDto")
//            dao.deleteEmotion(emotionDto)
//            call.respondText("userTask delete correctly", status = HttpStatusCode.Accepted)
//
//        }
//
//    }
    }
}
