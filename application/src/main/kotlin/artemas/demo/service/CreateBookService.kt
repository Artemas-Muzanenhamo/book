package artemas.demo.service

import artemas.demo.dto.BookDTO
import artemas.demo.ports.CreateABookPort
import artemas.demo.ports.CreateABookUseCase
import org.springframework.stereotype.Service

@Service
class CreateBookService(val createABookPort: CreateABookPort) : CreateABookUseCase {
    override fun createABook(bookDTO: BookDTO): BookDTO {
        return createABookPort.createABook(bookDTO)
    }
}