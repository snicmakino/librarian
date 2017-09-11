package jp.snicmakino.librarian.model

import com.fasterxml.jackson.annotation.JsonUnwrapped
import org.hibernate.validator.constraints.NotEmpty
import javax.validation.Valid
import javax.validation.constraints.Max
import javax.validation.constraints.Min

class Book {
    var id: Int = 0

    @NotEmpty
    var title: String? = null

    @Min(0)
    @Max(9999)
    var stock: Int? = null

    @JsonUnwrapped
    @Valid
    var isbn10: Isbn10 = Isbn10()

    @JsonUnwrapped
    @Valid
    var isbn13: Isbn13 = Isbn13()
}
