package artemas.demo.adapter.web.json

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class BookJson(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("bookName")
    val bookName: String,
    @JsonProperty("isbnNumber")
    val isbnNumber: Long
)
