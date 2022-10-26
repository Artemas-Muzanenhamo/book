package artemas.demo.adapter.persistence

import artemas.demo.adapter.persistence.entity.BookEntity
import artemas.demo.adapter.persistence.repository.BookRepository
import artemas.demo.dto.BookDTO
import artemas.demo.ports.UpdateABookPort
import org.springframework.stereotype.Component

@Component
class UpdateBookAdapter(private val bookRepository: BookRepository): UpdateABookPort {
    override fun updateBook(bookDto: BookDTO): BookDTO {
        val book = BookEntity(id = bookDto.id, bookName = bookDto.bookName, isbnNumber = bookDto.isbnNumber)

        val (id, bookName, isbnNumber) = bookRepository.save(book)

        return BookDTO(id = id, bookName = bookName, isbnNumber = isbnNumber)
    }
}
