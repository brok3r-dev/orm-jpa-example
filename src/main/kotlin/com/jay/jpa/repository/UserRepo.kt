package com.jay.jpa.repository

import com.jay.jpa.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepo: JpaRepository<User, Long> {
    fun findByName(name: String): List<User>?
    fun findByPhone(phone: String): User?
}