@file:JvmName("Main")
package org.ktalks.application

import org.jetbrains.exposed.sql.Database
import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.application.install
import org.jetbrains.ktor.host.embeddedServer
import org.jetbrains.ktor.http.ContentType
import org.jetbrains.ktor.logging.CallLogging
import org.jetbrains.ktor.netty.Netty
import org.jetbrains.ktor.response.respondRedirect
import org.jetbrains.ktor.response.respondText
import org.jetbrains.ktor.routing.Routing
import org.jetbrains.ktor.routing.get
import org.jetbrains.ktor.routing.post
import org.ktalks.view.getIndex
import org.ktalks.view.getNewTopic
import org.ktalks.view.getTopics
import org.ktalks.view.postNewTopic

fun Application.module() {
    install(CallLogging)
    install(Routing) {
        get("/") {
            call.respondText(getIndex(), ContentType.Text.Html)
        }
        get("/new-topic") {
            call.respondText(getNewTopic(), ContentType.Text.Html)
        }
        post("/new-topic") {
            val title = call.request.queryParameters["title"] ?: ""
            val text = call.request.queryParameters["text"] ?: ""
            postNewTopic(title, text)
            call.respondRedirect("/topics")
        }
        get("/topics") {
            call.respondText(getTopics(), ContentType.Text.Html)
        }
    }
}

fun main(args: Array<String>) {
    Database.connect("jdbc:mysql://localhost/ktalks?nullNamePatternMatchesAll=true", driver = "com.mysql.cj.jdbc.Driver", user = "root", password = "root")
    embeddedServer(Netty, 8080, reloadPackages = listOf("org.ktalks.ktalks-core"), module = Application::module).start()
}