package jp.snicmakino.librarian.controller

import jp.snicmakino.librarian.mapper.BookMapper
import org.springframework.web.bind.annotation.*
import jp.snicmakino.librarian.model.Book

@RestController
@RequestMapping("/books")
class BookController(val bookMapper: BookMapper) {

    @GetMapping
    fun index(): MutableList<Book> {
        return bookMapper.all()
    }

    @GetMapping("/{id}")
    fun show(@PathVariable id: Int): Book {
        return bookMapper.find(id)
    }

    @PostMapping
    fun store(): String {
        return "post"
    }

    @PutMapping("/{id}")
    fun update(): String {
        return "update"
    }

    @DeleteMapping("/{id}")
    fun delete(): String {
        return "delete"
    }
}