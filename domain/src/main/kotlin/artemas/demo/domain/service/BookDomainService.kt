package artemas.demo.domain.service

import artemas.demo.domain.entity.Book
import artemas.demo.domain.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookDomainService(private val bookRepository: BookRepository) {
    fun createABook(book: Book): Book {
        return bookRepository.save(book)
    }
}
