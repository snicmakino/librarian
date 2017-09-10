package jp.snicmakino.librarian.mapper

import jp.snicmakino.librarian.model.Book
import org.apache.ibatis.annotations.*

@Mapper
interface BookMapper {

    @Select("""
        SELECT
            *
        FROM
            book
    """)
    fun all(): MutableList<Book>

    @Select("""
        SELECT
            id
            ,title
            ,stock
            ,i10.isbn AS isbn10
            ,i13.isbn AS isbn13
        FROM
            book b
            LEFT OUTER JOIN
                isbn10 i10
            ON  b.id = i10.book_id
            LEFT OUTER JOIN
                isbn13 i13
            ON  b.id = i13.book_id
        WHERE
            id = #{id}
    """)
    @Results(
            Result(property = "isbn13.isbn", column = "isbn13"),
            Result(property = "isbn10.isbn", column = "isbn10"))
    fun find(id: Int): Book

    @Insert("""
        INSERT INTO book
            (title, stock)
        VALUES
            (#{title}, #{stock})
    """)
    @Options(useGeneratedKeys = true)
    fun register(book: Book)
}
