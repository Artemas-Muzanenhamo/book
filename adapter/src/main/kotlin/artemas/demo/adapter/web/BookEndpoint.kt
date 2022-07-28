package artemas.demo.adapter.web

import artemas.demo.adapter.web.json.BookJson
import artemas.demo.application.dto.BookDTO
import artemas.demo.application.ports.CreateABookUseCase
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class BookEndpoint(
    val createABookUseCase: CreateABookUseCase
) {

    @PostMapping("/book", consumes = [APPLICATION_JSON_VALUE])
    @ResponseStatus(CREATED)
    fun createABook(@RequestBody bookJson: BookJson): BookJson {
        val savedBook = createABookUseCase.createABook(bookJson.toDTO())
        return savedBook.toJson()
    }
}

private fun BookDTO.toJson(): BookJson {
    return BookJson(
        id = this.id,
        bookName = this.bookName,
        isbnNumber = this.isbnNumber
    )
}

private fun BookJson.toDTO(): BookDTO {
    return BookDTO(
        id = this.id,
        bookName = this.bookName,
        isbnNumber = this.isbnNumber
    )
}
