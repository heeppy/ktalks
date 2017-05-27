package org.ktalks.data.dao

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

/**
 * User database access object
 * @author mlshv
 */
class UserDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserDao>(Users)

    var email by Users.email
    var pass by Users.pass
    var role by Users.role
    var signUpDate by Users.signUpDate
    var lastSignInDate by Users.lastSignInDate
    var name by Users.name
}

object Users : IntIdTable() {
    val email = varchar("email", length = 50) // Column<String>
    val pass = varchar("pass", length = 100) // Column<String>
    val role = varchar("role", length = 10) // Column<String>
    val signUpDate = datetime("signUpDate") // Column<DateTime>
    val lastSignInDate = datetime("signUpDate") // Column<DateTime>
    val name = varchar("name", length = 50) // Column<String>
}