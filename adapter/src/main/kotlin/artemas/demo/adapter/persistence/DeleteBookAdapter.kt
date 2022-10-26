package artemas.demo.adapter.persistence

import artemas.demo.adapter.persistence.repository.BookRepository
import artemas.demo.adapter.web.exception.NotFoundException
import artemas.demo.ports.DeleteABookPort
import org.springframework.stereotype.Component

@Component
class DeleteBookAdapter(private val bookRepository: BookRepository): DeleteABookPort {
    override fun by(id: Long) {
        try {
            bookRepository.deleteById(id)
        } catch (e: Exception) {
            throw NotFoundException("Book with id: $id was not found")
        }
    }
}
