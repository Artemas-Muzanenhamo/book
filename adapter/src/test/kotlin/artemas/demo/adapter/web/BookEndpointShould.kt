package artemas.demo.adapter.web

import artemas.demo.application.dto.BookDTO
import artemas.demo.application.ports.CreateABookUseCase
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(BookEndpoint::class, CreateABookUseCase::class)
class BookEndpointShould {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var createABookUseCase: CreateABookUseCase

    @Test
    fun `Should save a book given a BookJson`() {
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
}