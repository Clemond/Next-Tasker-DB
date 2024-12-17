package com.clemond.next_tasker_db.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class BcryptPasswordEncoderConfig {

    @Bean
    fun bcryptPasswordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder(15)
    }
}