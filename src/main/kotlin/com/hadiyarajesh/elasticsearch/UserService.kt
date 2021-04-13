package com.hadiyarajesh.elasticsearch

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository,
) {
    fun saveUser(user: User): User {
        return userRepository.save(user)
    }

    fun searchUsers(text: String, page: Int, size: Int): Page<User> {
        val sort = Sort.by(Sort.Order.by("isActive")).descending().and(Sort.by("age").descending())
        val usernameQuery = if (text.contains(" ")) text.replace(" ", "") else text
        val pageable = PageRequest.of(page, size, sort)
        return userRepository.findAllByUsernameContainingOrFullName(usernameQuery, text, pageable)
    }
}