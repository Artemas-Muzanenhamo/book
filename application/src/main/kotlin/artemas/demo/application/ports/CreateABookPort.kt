package artemas.demo.application.ports

import artemas.demo.application.dto.BookDTO

interface CreateABookPort {
    fun createABook(bookDTO: BookDTO): BookDTO
}
