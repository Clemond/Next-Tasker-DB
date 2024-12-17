package com.clemond.next_tasker_db.user.repository

import com.clemond.next_tasker_db.user.model.CustomUser
import org.springframework.data.jpa.repository.JpaRepository

interface CustomUserRepository: JpaRepository<CustomUser, Long> {

    fun findUserByUsername(username: String): CustomUser?
}