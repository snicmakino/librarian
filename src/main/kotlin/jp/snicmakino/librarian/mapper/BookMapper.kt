package jp.snicmakino.librarian.mapper

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select
import jp.snicmakino.librarian.model.Book

@Mapper
interface BookMapper {

    @Select("""
        SELECT
            id, title, stock
        FROM
            book
        WHERE
            id = #{id}
    """)
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
