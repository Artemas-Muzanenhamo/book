package artemas.demo.service

import artemas.demo.dto.BookDTO
import artemas.demo.ports.UpdateABookPort
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class UpdateABookServiceTest {
    @Mock
    private lateinit var updateABookPort: UpdateABookPort
    @InjectMocks
    private lateinit var updateABookService: UpdateABookService

    @Test
    fun `Calls the UpdateABookPort given the book being updated exists`() {
        val book = BookDTO(id = 7823423, bookName = "Some Great Book", isbnNumber = 763287342942)

        updateABookService.update(book)

        verify(updateABookPort).updateBook(book)
    }
}
