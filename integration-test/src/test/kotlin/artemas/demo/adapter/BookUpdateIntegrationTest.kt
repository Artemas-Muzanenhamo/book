package artemas.demo.adapter

import artemas.demo.adapter.web.exception.NotFoundException
import artemas.demo.dto.BookDTO
import artemas.demo.ports.CreateABookUseCase
import artemas.demo.ports.UpdateABookUseCase
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
open class BookUpdateIntegrationTest {
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

    @Test
    fun `It throws a BookNotFoundException given an update to a non-existent book`() {
        val book = BookDTO(id = 34553235, bookName = "Great Expectations Edited", isbnNumber = 766554453)

        val exception = assertThatThrownBy { updateABookUseCase.update(book = book) }

        assertThat(exception.isInstanceOf(NotFoundException::class.java))
        assertThat(exception.hasMessage("Book Not Found"))
    }
}
