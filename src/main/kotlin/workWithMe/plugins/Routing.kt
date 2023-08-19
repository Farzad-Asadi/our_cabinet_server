package workWithMe.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import workWithMe.routes.apiRouting

fun Application.configureRouting() {
    routing {
        apiRouting()
    }
}
