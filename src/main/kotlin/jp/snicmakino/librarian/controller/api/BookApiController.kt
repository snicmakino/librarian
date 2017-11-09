package jp.snicmakino.librarian.controller.api

import jp.snicmakino.librarian.mapper.BookMapper
import jp.snicmakino.librarian.model.Book
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/books")
class BookApiController(val bookMapper: BookMapper) {

    @GetMapping
    fun index(): MutableList<Book> {
        return bookMapper.all()
    }

    @GetMapping("/{id}")
    fun show(@PathVariable id: Int): Book {
        return bookMapper.find(id)
    }

    @PostMapping
    @Transactional
    fun store(@RequestBody @Valid book: Book): Book {
        bookMapper.register(book)
        if (book.isbn10.value != null) { bookMapper.registerIsbn10(book) }
        if (book.isbn13.value != null) { bookMapper.registerIsbn13(book) }
        return book
    }

    @PutMapping("/{id}")
    @Transactional
    fun update(@PathVariable("id") id: Int, @RequestBody @Valid book: Book): Book {
        book.id = id
        bookMapper.update(book)
        if (book.isbn10.value != null) { bookMapper.updateIsbn10(book) }
        if (book.isbn13.value != null) { bookMapper.updateIsbn13(book) }
        return bookMapper.find(id)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int): String {
        return bookMapper.delete(id).toString()
    }
}
