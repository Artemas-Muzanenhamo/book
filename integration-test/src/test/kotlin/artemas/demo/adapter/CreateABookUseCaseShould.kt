package artemas.demo.adapter

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

    @Test
    fun `Create A Book`() {
        val book = BookDTO(id = 54325, bookName = "Great Expectations", isbnNumber = 9873459837534)

        val createdBook = createABookUseCase.createABook(book)

        assertThat(createdBook).isNotNull
    }
}
