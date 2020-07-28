package com.jun.moviecommunity.board.dto

import com.jun.moviecommunity.board.Board

class Article(board: Board) {
    val articleId = board.articleId
    val authorId = board.authorId
    val title = board.title
    val content = board.content
    val createdDate = board.createdDate
    val lastModified = board.lastModified
}