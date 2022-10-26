package artemas.demo.service

import artemas.demo.dto.BookDTO
import artemas.demo.ports.UpdateABookPort
import artemas.demo.ports.UpdateABookUseCase
import org.springframework.stereotype.Service

@Service
class UpdateABookService(private val updateABookPort: UpdateABookPort): UpdateABookUseCase {
    override fun update(book: BookDTO): BookDTO {
        return updateABookPort.updateBook(book)
    }
}
