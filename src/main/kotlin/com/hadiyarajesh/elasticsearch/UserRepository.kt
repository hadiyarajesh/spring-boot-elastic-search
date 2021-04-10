package com.hadiyarajesh.elasticsearch

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : ElasticsearchRepository<User, Long> {
    fun findAllByDescriptionContaining(description: String, pageable: Pageable): Page<User>

    fun findAllByUsernameContaining(username: String, pageable: Pageable): Page<User>

    fun findByEmail(email: String): User?
}