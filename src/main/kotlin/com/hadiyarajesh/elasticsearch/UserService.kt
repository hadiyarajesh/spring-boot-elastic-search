package com.hadiyarajesh.elasticsearch

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Slice
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository,
) {
    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    fun getUserByUsername(username: String, page: Int, size: Int): Page<User> {
        val pageable = PageRequest.of(page, size)
        return userRepository.findAllByUsernameContaining(username, pageable)
    }

    fun getUserByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }

    fun getUserByDescription(description: String, page: Int, size: Int): Page<User> {
        val pageable = PageRequest.of(page, size)
        return userRepository.findAllByDescriptionContaining(description, pageable)
    }
}