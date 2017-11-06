package jp.snicmakino.librarian.controller

import jp.snicmakino.librarian.mapper.BookMapper
import jp.snicmakino.librarian.model.Book
import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Controller
@RequestMapping("/books")
class BooksController(val bookMapper: BookMapper) {

    @GetMapping
    fun index(): String {
//        bookMapper.all()
        return "books/list"
    }

    @GetMapping("register")
    fun register(): String {
        return "books/register"
    }
}