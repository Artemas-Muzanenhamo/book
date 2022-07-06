package artemas.demo.adapter.persistence

import artemas.demo.adapter.persistence.repository.BookRepository
import artemas.demo.dto.BookDTO
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import

@Import(value = [CreateBookAdapter::class])
@DataJpaTest
internal class CreateBookAdapterTest {
    @Autowired
    private lateinit var createBookAdapter: CreateBookAdapter
    @Autowired
    private lateinit var bookRepository: BookRepository

    @Test
    fun `Should save book entity given a book DTO`() {
        val bookDTO = BookDTO(id = 12334, bookName = "Demo Book Name", isbnNumber = 987345395)

        val savedBook = createBookAdapter.createABook(bookDTO)

        assertThat(savedBook).isEqualTo(bookDTO)
    }

}