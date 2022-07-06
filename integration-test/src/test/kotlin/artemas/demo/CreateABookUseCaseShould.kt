package artemas.demo

import artemas.demo.dto.BookDTO
import artemas.demo.ports.CreateABookUseCase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CreateABookUseCaseShould {
    @Autowired
    private lateinit var createABookUseCase: CreateABookUseCase

    @Test
    fun `Create A Book`() {
        val book = BookDTO(id = 54325, bookName = "Great Expectations", isbnNumber = 9873459837534)

        val createdBook = createABookUseCase.createABook(book)

        assertThat(createdBook).isNotNull
    }
}