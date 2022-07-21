package artemas.demo.adapter.persistence

import artemas.demo.adapter.persistence.entity.BookEntity
import artemas.demo.adapter.persistence.repository.BookRepository
import artemas.demo.dto.BookDTO
import artemas.demo.ports.CreateABookPort
import org.springframework.stereotype.Component

@Component
class CreateBookAdapter(val bookRepository: BookRepository): CreateABookPort {
    override fun createABook(bookDTO: BookDTO): BookDTO {
        val (id, bookName, isbnNumber) = bookRepository.save(bookDTO.toEntity())

        return BookDTO(id = id, bookName = bookName, isbnNumber = isbnNumber)
    }
}

private fun BookDTO.toEntity(): BookEntity {
    return BookEntity(
        id = this.id,
        bookName = this.bookName,
        isbnNumber = this.isbnNumber
    )
}
