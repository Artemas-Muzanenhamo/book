package artemas.demo.application.service

import artemas.demo.application.dto.BookDTO
import artemas.demo.domain.entity.Book
import artemas.demo.domain.service.BookDomainService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class CreateBookServiceTest {
    @Mock
    private lateinit var bookDomainService: BookDomainService
    private lateinit var createBookService: CreateBookService

    @BeforeEach
    fun setup() {
        createBookService = CreateBookService(bookDomainService)
    }

    @Test
    fun `Should Create A Book And Return A Book Generated`() {
        val book = Book(id = 6748234, bookName = "Harry Porter", isbnNumber = 346287432)
        given(bookDomainService.createABook(book)).willReturn(book)

        val bookDTO = BookDTO(id = book.id, bookName = book.bookName, isbnNumber = book.isbnNumber)
        val createdBook = createBookService.createABook(bookDTO)

        assertThat(createdBook).isNotNull
        verify(bookDomainService).createABook(book)
    }
}
