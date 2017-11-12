package jp.snicmakino.librarian.controller

import jp.snicmakino.librarian.mapper.BookMapper
import jp.snicmakino.librarian.model.Book
import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Transactional
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import org.springframework.beans.propertyeditors.CustomDateEditor
import java.text.SimpleDateFormat
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.InitBinder



@Controller
@RequestMapping("/books")
class BookController(val bookMapper: BookMapper) {

    @GetMapping
    fun index(model: Model): String {
        model.addAttribute("books", bookMapper.all())
        return "books/list"
    }

    @GetMapping("register")
    fun register(): String {
        return "books/register"
    }

    @ModelAttribute
    fun setupBook(): Book {
        return Book()
    }

    @PostMapping()
    fun store(@ModelAttribute @Valid book: Book, model: Model): String {
        bookMapper.register(book)
        if (book.isbn10.value != null) {
            bookMapper.registerIsbn10(book)
        }
        if (book.isbn13.value != null) {
            bookMapper.registerIsbn13(book)
        }
        return "redirect:/books"
    }

    @PostMapping("update/{id}")
    @Transactional
    fun update(@PathVariable("id") id: Int, @ModelAttribute @Valid book: Book): String {
        book.id = id
        bookMapper.update(book)
        if (book.isbn10.value != null) {
            bookMapper.updateIsbn10(book)
        }
        if (book.isbn13.value != null) {
            bookMapper.updateIsbn13(book)
        }
        return "redirect:/books"
    }

    @PostMapping("delete/{id}")
    fun delete(@PathVariable("id") id: Int): String {
        bookMapper.delete(id).toString()
        return "redirect:/books"
    }
}