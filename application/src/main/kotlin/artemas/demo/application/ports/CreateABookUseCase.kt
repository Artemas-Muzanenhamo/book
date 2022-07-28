package artemas.demo.application.ports

import artemas.demo.application.dto.BookDTO

interface CreateABookUseCase {
    fun createABook(bookDTO: BookDTO): BookDTO
}
