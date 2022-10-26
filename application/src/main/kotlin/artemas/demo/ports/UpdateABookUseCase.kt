package artemas.demo.ports

import artemas.demo.dto.BookDTO

interface UpdateABookUseCase {
    fun update(book: BookDTO): BookDTO
}
