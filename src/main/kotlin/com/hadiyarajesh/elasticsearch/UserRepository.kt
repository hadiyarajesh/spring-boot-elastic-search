package com.hadiyarajesh.elasticsearch

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : ElasticsearchRepository<User, Long> {
    fun findAllByUsernameContainingOrFullName(username: String, fullName: String, pageable: Pageable): Page<User>
}