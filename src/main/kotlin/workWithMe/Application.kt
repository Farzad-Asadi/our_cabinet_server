package workWithMe

import io.ktor.server.application.*
import workWithMe.db.DatabaseFactory
import workWithMe.plugins.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    //    log.info("Hello from module!")
    DatabaseFactory.init(environment.config)
    configureSerialization()
    configureRouting()
}
