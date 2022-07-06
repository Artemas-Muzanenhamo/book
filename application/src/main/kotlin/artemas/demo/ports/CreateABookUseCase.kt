package artemas.demo.ports

import artemas.demo.dto.BookDTO

interface CreateABookUseCase {
    fun createABook(bookDTO: BookDTO): BookDTO
}
