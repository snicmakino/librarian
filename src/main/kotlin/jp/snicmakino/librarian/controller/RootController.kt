package jp.snicmakino.librarian.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class RootController {

    @GetMapping("/")
    fun index(): String {
        return "index"
    }
}
