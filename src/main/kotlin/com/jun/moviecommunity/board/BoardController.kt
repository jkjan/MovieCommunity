package com.jun.moviecommunity.board

import com.jun.moviecommunity.board.dto.Article
import com.jun.moviecommunity.board.dto.FullPage
import com.jun.moviecommunity.board.dto.PostArticle
import com.jun.moviecommunity.logger
import org.springframework.web.bind.annotation.*

@RestController
class BoardController(private val boardService: BoardService) {
    val log = logger()
    @GetMapping(path = ["/board/all"])
    fun getAllArticles() : List<FullPage> {
        log.info("GETTING ALL ARTICLES")
        return boardService.getAllArticles()
    }

    @GetMapping(path = ["/board/{articleId}"])
    fun getArticle(@PathVariable(name = "articleId") articleId : Int) : Article? {
        return boardService.getArticle(articleId)
    }

    @PostMapping(path = ["/board"])
    fun postArticle(@RequestBody article: PostArticle) : Int {
        log.info("article : $article")
        return boardService.postArticle(article)
    }

    @PutMapping(path = ["/board/edit/{articleId}"])
    fun editArticle(@PathVariable("articleId") articleId: Int, @RequestBody article: Board) : Int {
        log.info("article : $article")
        return boardService.editArticle(articleId, article)
    }

    @DeleteMapping(path = ["/board/{articleId}"])
    fun deleteArticle(@PathVariable(name = "articleId") articleId: Int) {
        return boardService.deleteArticle(articleId)
    }
}