package artemas.demo.application.service

import artemas.demo.application.dto.BookDTO
import artemas.demo.application.ports.CreateABookUseCase
import artemas.demo.domain.entity.Book
import artemas.demo.domain.service.BookDomainService
import org.springframework.stereotype.Service

@Service
class CreateBookService(private val bookDomainService: BookDomainService) : CreateABookUseCase {
    override fun createABook(bookDTO: BookDTO): BookDTO {
        val savedBookEntity = bookDomainService.createABook(bookDTO.toEntity())

        return savedBookEntity.toDTO()
    }

    private fun BookDTO.toEntity(): Book {
        return Book(
            id = this.id,
            bookName = this.bookName,
            isbnNumber = this.isbnNumber
        )
    }
}

private fun Book.toDTO(): BookDTO {
    return BookDTO(
        id = this.id,
        bookName = this.bookName,
        isbnNumber = this.isbnNumber
    )
}
