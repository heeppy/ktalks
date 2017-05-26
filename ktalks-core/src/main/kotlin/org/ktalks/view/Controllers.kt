package org.ktalks.view

import org.jtwig.JtwigModel
import org.jtwig.JtwigTemplate

/**
 * Location controllers
 * @author mlshv
 */
fun getIndex(): String {
    val template = JtwigTemplate.classpathTemplate("templates/index.html")
    val model = JtwigModel.newModel().with("value", "The Lonely Stranger")
    return template.render(model)
}

fun getNewTopic(): String {
    val template = JtwigTemplate.classpathTemplate("templates/new-topic.html")
    return template.render(JtwigModel.newModel())
}