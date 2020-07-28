package com.jun.moviecommunity.board

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Board (
     val authorId : Int,
     val title : String,
     val content : String
) {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     var articleId : Int = 0
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     lateinit var createdDate : String
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     lateinit var lastModified: String
}