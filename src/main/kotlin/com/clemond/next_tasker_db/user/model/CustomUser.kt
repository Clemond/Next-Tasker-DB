package com.clemond.next_tasker_db.user.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size


@Entity
class CustomUser (
    @field:NotEmpty
    @field:Size(min = 2, max = 20)
    val username: String,

    @field:NotEmpty
    @field:Size(min = 5, max = 50)
    val password: String,

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null
) {
}