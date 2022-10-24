package artemas.demo.service

import artemas.demo.ports.DeleteABookPort
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class DeleteABookServiceTest {
    @Mock
    private lateinit var deleteABookPort: DeleteABookPort
    @InjectMocks
    private lateinit var deleteABookService: DeleteABookService

    @Test
    fun `calls the DeleteABookPort given an isbnNumber`() {
        deleteABookService.deleteBy(89723423)

        verify(deleteABookPort).by(89723423)
    }
}
