package com.jun.moviecommunity.user

import com.jun.moviecommunity.logger
import com.jun.moviecommunity.user.dto.UserName
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userService: UserService) {
    val log = logger()
    @GetMapping(path = ["/user/all"])
    fun getAllUsers() : List<User> {
        log.info("GETTING ALL USERS")
        return userService.getAllUsers()
    }

    @GetMapping(path = ["/user/{userId}"])
    fun getUser(@PathVariable("userId") userId : Int) : UserName? {
        log.info("GETTING A USER OF $userId")
        return userService.getUser(userId)
    }
}