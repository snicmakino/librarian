package jp.snicmakino.librarian.model

import com.fasterxml.jackson.annotation.JsonProperty

class Isbn13 (
        @JsonProperty("isbn13")
        var isbn: String
)
