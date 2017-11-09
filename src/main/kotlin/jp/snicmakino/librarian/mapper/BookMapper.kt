package jp.snicmakino.librarian.mapper

import jp.snicmakino.librarian.model.Book
import org.apache.ibatis.annotations.*

@Mapper
interface BookMapper {

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
    """)
    @Results(
            Result(property = "isbn13.value", column = "isbn13"),
            Result(property = "isbn10.value", column = "isbn10"))
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
            Result(property = "isbn13.value", column = "isbn13"),
            Result(property = "isbn10.value", column = "isbn10"))
    fun find(id: Int): Book

    @Insert("""
        INSERT INTO book
            (title, stock)
        VALUES
            (#{title}, #{stock})
    """)
    @Options(useGeneratedKeys = true)
    fun register(book: Book)

    @Insert("""
        INSERT INTO isbn10
            (book_id, isbn)
        VALUES
            (#{id}, #{isbn10.value})
    """)
    fun registerIsbn10(book: Book)

    @Update("""
        <script>
            UPDATE book
            <set>
                <if test="title != null">title = #{title},</if>
                <if test="stock != null">stock = #{stock},</if>
            </set>
            WHERE id = #{id}
        </script>
    """)
    fun update(book: Book)

    @Insert("""
        INSERT INTO isbn13
            (book_id, isbn)
        VALUES
            (#{id}, #{isbn13.value})
    """)
    fun registerIsbn13(book: Book)

    @Update("""
        update isbn10
        set isbn = #{isbn10.value}
        where book_id = #{id}
    """)
    fun updateIsbn10(book: Book)

    @Update("""
        update isbn13
        set isbn = #{isbn13.value}
        where book_id = #{id}
    """)
    fun updateIsbn13(book: Book)

    @Delete("""
        DELETE FROM book WHERE id = #{id}
    """)
    fun delete(id: Int): Boolean
}
