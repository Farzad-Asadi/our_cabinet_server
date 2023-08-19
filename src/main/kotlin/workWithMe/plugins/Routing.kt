package workWithMe.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import workWithMe.routes.userRouting

fun Application.configureRouting() {
    routing {
        userRouting()
    }
}
