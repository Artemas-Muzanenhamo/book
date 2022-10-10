package artemas.demo.service

import artemas.demo.dto.BookDTO
import artemas.demo.ports.CreateABookPort
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class CreateBookServiceTest {
    @Mock
    lateinit var createABookPort: CreateABookPort
    @InjectMocks
    lateinit var createBookService: CreateBookService

    @Test
    fun `Calls createABookPort() to Create A Book And Return A Book Generated`() {
        val bookDTO = BookDTO(id = 6748234, bookName = "Harry Porter", isbnNumber = 346287432)
        given(createABookPort.createABook(bookDTO)).willReturn(bookDTO)

        val createdBook = createBookService.createABook(bookDTO)

        assertThat(createdBook).isNotNull
        verify(createABookPort).createABook(bookDTO)
    }
}
