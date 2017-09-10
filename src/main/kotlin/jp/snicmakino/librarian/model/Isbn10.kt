package jp.snicmakino.librarian.model

import com.fasterxml.jackson.annotation.JsonProperty

class Isbn10(
        @JsonProperty("isbn10")
        var isbn: String
)
