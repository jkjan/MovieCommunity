package com.jun.moviecommunity.board.dto

import com.jun.moviecommunity.board.Board

class FullPage (board: Board) {
    val articleId = board.articleId
    val title = board.title
    val createdDate = board.createdDate
}