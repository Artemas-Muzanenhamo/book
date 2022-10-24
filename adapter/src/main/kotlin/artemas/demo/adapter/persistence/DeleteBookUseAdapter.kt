package artemas.demo.adapter.persistence

import artemas.demo.adapter.persistence.repository.BookRepository
import artemas.demo.ports.DeleteABookPort
import org.springframework.stereotype.Component

@Component
class DeleteBookUseAdapter(private val bookRepository: BookRepository): DeleteABookPort {
    override fun by(id: Long) {
        bookRepository.deleteById(id)
    }
}
