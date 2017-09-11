package jp.snicmakino.librarian.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length

class Isbn10 {
    @JsonProperty("isbn10")
    @Length(min = 10, max = 20)
    var isbn: String? = null
}
