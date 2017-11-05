package jp.snicmakino.librarian.controller

import jp.snicmakino.librarian.mapper.BookMapper
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class RootController(val bookMapper: BookMapper) {

    @GetMapping
    fun index(): String {
        return "index"
    }

    @GetMapping("plain_page")
    fun plainPage(): String {
        return "plain_page"
    }
}