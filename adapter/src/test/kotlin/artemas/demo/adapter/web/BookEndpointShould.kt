package artemas.demo.adapter.web

import artemas.demo.adapter.web.exception.NotFoundException
import artemas.demo.dto.BookDTO
import artemas.demo.ports.CreateABookUseCase
import artemas.demo.ports.DeleteABookUseCase
import artemas.demo.ports.UpdateABookUseCase
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(BookEndpoint::class, CreateABookUseCase::class)
class BookEndpointShould {
    @Autowired
    private lateinit var mockMvc: MockMvc
    @MockBean
    private lateinit var createABookUseCase: CreateABookUseCase
    @MockBean
    private lateinit var deleteABookUseCase: DeleteABookUseCase
    @MockBean
    private lateinit var updateABookUseCase: UpdateABookUseCase
    @MockBean
    private lateinit var logger: Logger

    @Test
    fun `Saves a book given a BookJson and returns a BookJson when saving completes`() {
        val bookDTO = BookDTO(id = 123413, bookName = "Lord of the Flies", isbnNumber = 894379345)
        given(createABookUseCase.createABook(bookDTO)).willReturn(bookDTO)

        mockMvc.perform(
            post("/book")
                .accept(APPLICATION_JSON_VALUE)
                .contentType(APPLICATION_JSON_VALUE)
                .content(
                    """
                {
                    "id": 123413,
                    "bookName": "Lord of the Flies",
                    "isbnNumber": 894379345
                }
            """.trimIndent()
                )
        ).andExpect(status().isCreated)
            .andExpect(
                content().json(
                    """{
                    "id": 123413,
                    "bookName": "Lord of the Flies",
                    "isbnNumber": 894379345
                }"""
                )
            )
    }

    @Test
    fun `Deletes a book given an existing Book ISBN number`() {
        mockMvc.perform(
            delete("/book")
                .accept(APPLICATION_JSON_VALUE)
                .contentType(APPLICATION_JSON_VALUE)
                .content(
                    """
                    {
                        "isbnNumber": "894379345"
                    }
                    """.trimIndent()
                )
        ).andExpect(status().isOk)
    }

    @Test
    fun `Throws an InvalidBookIdException when trying to delete a non existent book`() {
        given(deleteABookUseCase.deleteBy(894379345)).willThrow(NotFoundException("Book with id: 894379345 was not found"))

        mockMvc.perform(
            delete("/book")
                .accept(APPLICATION_JSON_VALUE)
                .contentType(APPLICATION_JSON_VALUE)
                .content(
                    """
                    {
                        "isbnNumber": "894379345"
                    }
                    """.trimIndent()
                )
        ).andExpect(status().isBadRequest).andExpect(content().string("An Invalid Book Id was supplied"))
    }

    @Test
    fun `Returns a 200 OK on successful update of an already existing book`() {
        val bookDTO = BookDTO(id = 67832402348, bookName = "Kobe Bryant Documentary", isbnNumber = 836647362)
        given(updateABookUseCase.update(bookDTO)).willReturn(bookDTO)

        mockMvc.perform(
            put("/book")
                .accept(APPLICATION_JSON_VALUE)
                .contentType(APPLICATION_JSON_VALUE)
                .content(
                    """
                        {
                            "id": 67832402348,
                            "bookName": "Kobe Bryant Documentary",
                            "isbnNumber": 836647362
                        }
                    """.trimIndent()
                )
        ).andExpect(status().isOk)
            .andExpect(
                content().json(
                    """{
                    "id": 67832402348,
                    "bookName": "Kobe Bryant Documentary",
                    "isbnNumber": 836647362
                }"""
                )
            )
    }

    @Test
    fun `Throws an InvalidBookException when trying to update a non existent book`() {
        val book = BookDTO(id = 67832402348, bookName = "Kobe Bryant Documentary", isbnNumber = 836647362)
        given(updateABookUseCase.update(book)).willThrow(NotFoundException("Book with id: 894379345 was not found"))

        mockMvc.perform(
            put("/book")
                .accept(APPLICATION_JSON_VALUE)
                .contentType(APPLICATION_JSON_VALUE)
                .content(
                    """
                        {
                            "id": 67832402348,
                            "bookName": "Kobe Bryant Documentary",
                            "isbnNumber": 836647362
                        }
                    """.trimIndent()
                )
        ).andExpect(status().isBadRequest).andExpect(content().string("An Invalid Book Id was supplied"))
    }
}
