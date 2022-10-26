package artemas.demo.adapter

import artemas.demo.dto.BookDTO
import artemas.demo.ports.CreateABookUseCase
import artemas.demo.ports.UpdateABookUseCase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookUpdateIntegrationTest {
    @Autowired
    private lateinit var updateABookUseCase: UpdateABookUseCase
    @Autowired
    private lateinit var createABookUseCase: CreateABookUseCase

    @Test
    fun `It updates a book given the book exists`() {
        val book = BookDTO(id = 54325, bookName = "Great Expectations Edited", isbnNumber = 9873459837534)
        createABookUseCase.createABook(book)
        val bookEdited = BookDTO(id = 54325, bookName = "Great Expectations Edited", isbnNumber = 9873459837534)

        val updatedBook = updateABookUseCase.update(book = bookEdited)

        assertThat(updatedBook).isEqualTo(bookEdited)
    }
}
