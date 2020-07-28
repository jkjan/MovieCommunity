package com.jun.moviecommunity.user

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name="user")
data class User (
        val name : String
) {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var userId : Int = 0
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        lateinit var registerDate : String
}