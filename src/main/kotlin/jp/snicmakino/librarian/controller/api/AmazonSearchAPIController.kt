package jp.snicmakino.librarian.controller.api

import khttp.get
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/amazon/search")
class AmazonSearchAPIController() {

    @GetMapping
    fun index(@RequestParam("value") value: String): String {
        val url = if (!value.startsWith("http")) "http://amazon.jp/dp/" + value else value
        return get(url).text
    }
}
