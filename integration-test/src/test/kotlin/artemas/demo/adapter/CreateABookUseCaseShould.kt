package artemas.demo.adapter

import artemas.demo.adapter.persistence.repository.BookRepository
import artemas.demo.dto.BookDTO
import artemas.demo.ports.CreateABookUseCase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CreateABookUseCaseShould {
    @Autowired
    private lateinit var createABookUseCase: CreateABookUseCase
    @Autowired
    private lateinit var logger: Logger
    @Autowired
    private lateinit var bookRepository: BookRepository

    @Test
    fun `It saves a book given a valid id, book name and valid isbn number`() {
        val book = BookDTO(id = 54325, bookName = "Great Expectations", isbnNumber = 9873459837534)

        val createdBook: BookDTO = createABookUseCase.createABook(book)

        // Returned when Persisted
        assertThat(createdBook).isNotNull
            .hasFieldOrPropertyWithValue("id", 54325L)
            .hasFieldOrPropertyWithValue("bookName", "Great Expectations")
            .hasFieldOrPropertyWithValue("isbnNumber", 9873459837534L)

        // Persisted Values in the DB
        val (id, bookName, isbnNumber) = bookRepository.findAll().first()
        assertThat(id).isEqualTo(54325L)
        assertThat(bookName).isEqualTo("Great Expectations")
        assertThat(isbnNumber).isEqualTo(9873459837534L)
    }
}
