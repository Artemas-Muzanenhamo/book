package artemas.demo.adapter.web

import artemas.demo.adapter.web.json.BookIsbnJson
import artemas.demo.adapter.web.json.BookJson
import artemas.demo.dto.BookDTO
import artemas.demo.ports.CreateABookUseCase
import artemas.demo.ports.DeleteABookUseCase
import artemas.demo.ports.UpdateABookUseCase
import org.slf4j.Logger
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class BookEndpoint(
    val createABookUseCase: CreateABookUseCase,
    val deleteABookUseCase: DeleteABookUseCase,
    val updateABookUseCase: UpdateABookUseCase,
    val logger: Logger
) {

    @PostMapping("/book", consumes = [APPLICATION_JSON_VALUE])
    @ResponseStatus(CREATED)
    fun createABook(@RequestBody bookJson: BookJson): BookJson {
        val savedBook = createABookUseCase.createABook(bookJson.toDTO())
        logger.info("SAVING BOOK: $savedBook")
        return savedBook.toJson()
    }

    @DeleteMapping("/book", consumes = [APPLICATION_JSON_VALUE])
    @ResponseStatus(OK)
    fun deleteABookBy(@RequestBody bookIsbnJson: BookIsbnJson) {
        deleteABookUseCase.deleteBy(bookIsbnJson.isbnNumber)
    }

    @PutMapping("/book")
    @ResponseStatus(OK)
    fun updateBook(@RequestBody bookJson: BookJson): BookJson {
        val updatedBook = updateABookUseCase.update(bookJson.toDTO())
        return updatedBook.toJson()
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
