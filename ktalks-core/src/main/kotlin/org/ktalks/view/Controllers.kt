package org.ktalks.view

import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import org.jtwig.JtwigModel
import org.jtwig.JtwigTemplate
import org.ktalks.data.dao.TopicDao
import org.ktalks.data.dao.Topics

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

fun getTopics(): String {
    val template = JtwigTemplate.classpathTemplate("templates/topics.html")
    val topics = mutableListOf("Topic #1", "Topic #2", "Topic #3")
    transaction {
        Topics.selectAll().forEach { topics.add(it[Topics.title]) }
    }
    val model = JtwigModel.newModel(mapOf("topics" to topics))
    return template.render(model)
}

fun postNewTopic(title: String, text: String): String {
    if (title.isNotBlank() && text.isNotBlank()) {
        transaction {
            TopicDao.new {
                this.title = title
                this.text = text
                created = DateTime.now()
                updated = DateTime.now()
            }
        }
        return getTopics()
    } else {
        return getNewTopic()
    }
}