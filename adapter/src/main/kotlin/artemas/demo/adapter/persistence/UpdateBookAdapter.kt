package artemas.demo.adapter.persistence

import artemas.demo.adapter.persistence.entity.BookEntity
import artemas.demo.adapter.persistence.repository.BookRepository
import artemas.demo.adapter.web.exception.NotFoundException
import artemas.demo.dto.BookDTO
import artemas.demo.ports.UpdateABookPort
import org.springframework.stereotype.Component

@Component
class UpdateBookAdapter(private val bookRepository: BookRepository): UpdateABookPort {
    override fun updateBook(bookDto: BookDTO): BookDTO {
        val book = BookEntity(id = bookDto.id, bookName = bookDto.bookName, isbnNumber = bookDto.isbnNumber)

        return bookRepository.findById(book.id)
            .map { bookRepository.save(book) }
            .map { BookDTO(id = it.id, bookName = it.bookName, isbnNumber = it.isbnNumber) }
            .orElseThrow { NotFoundException("Book Not Found") }
    }
}
