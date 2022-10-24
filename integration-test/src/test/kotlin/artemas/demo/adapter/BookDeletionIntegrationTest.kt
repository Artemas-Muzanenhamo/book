package artemas.demo.adapter

import artemas.demo.adapter.persistence.repository.BookRepository
import artemas.demo.dto.BookDTO
import artemas.demo.ports.CreateABookUseCase
import artemas.demo.ports.DeleteABookUseCase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
open class BookDeletionIntegrationTest {
    @Autowired
    private lateinit var createABookUseCase: CreateABookUseCase
    @Autowired
    private lateinit var deleteABookUseCase: DeleteABookUseCase
    @Autowired
    private lateinit var bookRepository: BookRepository

    @Test
    fun `Deletes an existing book given a valid book id`() {
        val book = BookDTO(id = 54325, bookName = "Great Expectations", isbnNumber = 9873459837534)
        createABookUseCase.createABook(book)

        deleteABookUseCase.deleteBy(id = book.id)

        assertThat(bookRepository.count()).isZero
    }
}
