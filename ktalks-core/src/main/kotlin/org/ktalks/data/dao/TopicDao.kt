package org.ktalks.data.dao

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

/**
 * Topic database access object
 * @author mlshv
 */
class TopicDao(id: EntityID<Int>) : IntEntity(id)  {
    companion object : IntEntityClass<TopicDao>(Topics)

    var title by Topics.title
    var text by Topics.text
    var created by Topics.created
    //var createdBy by Topics.createdBy TODO User reference
    var updated by Topics.updated
    // var responses by Topics.responses TODO Responses reference
}

object Topics : IntIdTable() {
    val title = varchar("title", length = 50) // Column<String>
    val text = text("text") // Column<String>
    val created = datetime("signUpDate") // Column<DateTime>
    //val createdBy = reference("createdBy", Users) TODO Users reference
    val updated = datetime("updated") // Column<DateTime>
    // val responses TODO Responses reference
}