package com.clemond.next_tasker_db.user.controller

import com.clemond.next_tasker_db.user.model.CustomUser
import com.clemond.next_tasker_db.user.repository.CustomUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class CustomUserController (
    @Autowired val customUserRepository: CustomUserRepository,
    @Autowired val passwordEncoder: PasswordEncoder
){

    @PostMapping
    fun saveUser(
        @Validated @RequestBody newUser: CustomUser
    ): ResponseEntity<String> {

        val bcryptUser = CustomUser(
            newUser.username,
            passwordEncoder.encode(newUser.password)
        )

        customUserRepository.save(bcryptUser)

        return ResponseEntity.status(201).body("user was successfully created")
    }

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<CustomUser>> {
        val users: List<CustomUser> = customUserRepository.findAll()
        return ResponseEntity.ok(users)
    }


}