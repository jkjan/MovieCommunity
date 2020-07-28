package com.jun.moviecommunity.user

import com.jun.moviecommunity.user.dto.UserName
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun getAllUsers(): List<User> = userRepository.findAll()
    fun getUser(userId: Int): UserName? {
        val user = userRepository.findById(userId)
        return if (user.isPresent)
            UserName(user.get())
        else
            null
    }
}