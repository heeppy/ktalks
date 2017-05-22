package org.ktalks.core

import org.jetbrains.ktor.application.*
import org.jetbrains.ktor.host.*
import org.jetbrains.ktor.http.*
import org.jetbrains.ktor.jetty.*
import org.jetbrains.ktor.logging.*
import org.jetbrains.ktor.response.*
import org.jetbrains.ktor.routing.*

fun Application.module() {
    install(CallLogging)
    install(Routing) {
        get("/") {
            call.respondText("Hello, Ktalks!", ContentType.Text.Html)
        }
    }
}

fun main(args: Array<String>) {
    embeddedServer(Jetty, 8080, reloadPackages = listOf("org.ktalks.ktalks-core"), module = Application::module).start()
}