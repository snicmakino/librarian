package jp.snicmakino.librarian.model

import com.fasterxml.jackson.annotation.JsonUnwrapped

class Book {
    var id: Int = 0
    var title: String = ""
    var stock: Int = 0
    @JsonUnwrapped
    var isbn10: Isbn10 = Isbn10("")
    @JsonUnwrapped
    var isbn13: Isbn13 = Isbn13("")
}
