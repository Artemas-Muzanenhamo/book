package artemas.demo.adapter

import artemas.demo.dto.BookDTO
import artemas.demo.ports.CreateABookUseCase
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.from
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookCreationIntegrationTest {
    @Autowired
    private lateinit var createABookUseCase: CreateABookUseCase

    @Test
    fun `It saves a book given a valid id, book name and valid isbn number`() {
        val book = BookDTO(id = 54325, bookName = "Great Expectations", isbnNumber = 9873459837534)

        val createdBook: BookDTO = createABookUseCase.createABook(book)

        assertThat(createdBook).isNotNull
            .returns(book.id, from(BookDTO::id))
            .returns(book.bookName, from(BookDTO::bookName))
            .returns(book.isbnNumber, from(BookDTO::isbnNumber))
    }
}
