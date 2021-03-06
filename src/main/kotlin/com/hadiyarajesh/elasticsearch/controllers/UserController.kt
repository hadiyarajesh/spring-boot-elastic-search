package com.hadiyarajesh.elasticsearch.controllers

import com.hadiyarajesh.elasticsearch.models.User
import com.hadiyarajesh.elasticsearch.services.UserService
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping("/create")
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        val createdUser = userService.saveUser(user)
        return ResponseEntity.ok().body(createdUser)
    }

    @GetMapping("/search")
    fun searchUsers(
        @RequestParam text: String,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "15") size: Int
    ): ResponseEntity<Page<User>> {
        val users = userService.searchUsers(text, page, size)
        return ResponseEntity.ok(users)
    }
}