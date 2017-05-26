@file:JvmName("Main")
package org.ktalks.application

import org.jetbrains.ktor.application.*
import org.jetbrains.ktor.host.*
import org.jetbrains.ktor.http.*
import org.jetbrains.ktor.netty.Netty
import org.jetbrains.ktor.logging.*
import org.jetbrains.ktor.response.*
import org.jetbrains.ktor.routing.*
import org.ktalks.view.*


fun Application.module() {
    install(CallLogging)
    install(Routing) {
        get("/") {
            call.respondText(getIndex(), ContentType.Text.Html)
        }
        get("/new-topic") {
            call.respondText(getNewTopic(), ContentType.Text.Html)
        }
    }
}

fun main(args: Array<String>) {
    embeddedServer(Netty, 8080, reloadPackages = listOf("org.ktalks.ktalks-core"), module = Application::module).start()
}