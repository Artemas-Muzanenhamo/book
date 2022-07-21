package artemas.demo.ports

import artemas.demo.dto.BookDTO

interface CreateABookPort {
    fun createABook(bookDTO: BookDTO): BookDTO
}
