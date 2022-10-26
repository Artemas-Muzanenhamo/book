package artemas.demo.ports

import artemas.demo.dto.BookDTO

interface UpdateABookPort {
    fun updateBook(book: BookDTO): BookDTO
}
