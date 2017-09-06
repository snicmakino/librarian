package jp.snicmakino.librarian

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class LibrarianApplication

fun main(args: Array<String>) {
    SpringApplication.run(LibrarianApplication::class.java, *args)
}
