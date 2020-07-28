package com.jun.moviecommunity.board.dto

import com.jun.moviecommunity.board.Board

data class PostArticle (
        val authorId : Int,
        val title : String,
        val content : String
) {
    fun toEntity() : Board {
        return Board(authorId, title, content)
    }
}