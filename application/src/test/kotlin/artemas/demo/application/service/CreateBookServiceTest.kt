package artemas.demo.application.service

import artemas.demo.application.dto.BookDTO
import artemas.demo.domain.entity.Book
import artemas.demo.domain.service.BookDomainService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class CreateBookServiceTest {
    private val bookDomainService = Mockito.mock(BookDomainService::class.java)
    lateinit var createBookService: CreateBookService

    @BeforeEach
    fun setup() {
        createBookService = CreateBookService(bookDomainService)
    }

    @Test
    fun `Should Create A Book And Return A Book Generated`() {
        val bookDTO = BookDTO(id = 6748234, bookName = "Harry Porter", isbnNumber = 346287432)
        val book = Book(id = bookDTO.id, bookName = bookDTO.bookName, isbnNumber = bookDTO.isbnNumber)
        given(bookDomainService.createABook(book)).willReturn(book)

        val createdBook = createBookService.createABook(bookDTO)

        assertThat(createdBook).isNotNull
        verify(bookDomainService).createABook(book)
    }
}