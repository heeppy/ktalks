package org.ktalks.data.dao

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

/**
 * Topic response database access object
 * @author mlshv
 */
class TopicResponseDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TopicResponseDao>(TopicResponses)

    var text by TopicResponses.text
    var created by TopicResponses.created
    var updated by TopicResponses.updated
    // var createdBy by TopicResponses.createdBy TODO Users reference
}

object TopicResponses : IntIdTable() {
    val text = text("text") // Column<String>
    val created = datetime("signUpDate") // Column<DateTime>
    val updated = datetime("updated") // Column<DateTime>
    // val createdBy = reference("createdBy", Users) TODO Users reference
}