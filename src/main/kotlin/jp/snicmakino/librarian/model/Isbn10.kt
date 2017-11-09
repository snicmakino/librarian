package jp.snicmakino.librarian.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length

class Isbn10 {
    @JsonProperty("isbn10")
    var value: String? = null
}
