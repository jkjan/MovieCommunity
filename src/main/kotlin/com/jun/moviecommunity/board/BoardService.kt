package com.jun.moviecommunity.board

import com.jun.moviecommunity.board.dto.Article
import com.jun.moviecommunity.board.dto.FullPage
import com.jun.moviecommunity.board.dto.PostArticle
import com.jun.moviecommunity.logger
import org.springframework.stereotype.Service

@Service
class BoardService (private val boardRepository: BoardRepository) {
    val log = logger()
    fun getAllArticles() : List<FullPage> {
        return boardRepository.findAll().map {
            FullPage(it)
        }
    }

    fun getArticle(articleId: Int) : Article? {
        val article = boardRepository.findById(articleId)
        return if (article.isPresent) {
            Article(article.get())
        }
        else
            null
    }

    fun postArticle(article: PostArticle): Int {
        return try {
            log.info("created board : ${article.toEntity()}")
            boardRepository.save(article.toEntity())
            200
        } catch (e : Exception) {
            400
        }
    }

    fun editArticle(articleId: Int, article: Board): Int {
        return try {
            boardRepository.save(article)
            200
        } catch (e : Exception) {
            400
        }
    }

    fun deleteArticle(articleId: Int) {
        boardRepository.deleteById(articleId)
    }
}