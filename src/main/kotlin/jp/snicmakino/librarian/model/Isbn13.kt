package jp.snicmakino.librarian.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length

class Isbn13 {
    @JsonProperty("isbn13")
    var value: String? = null
}

