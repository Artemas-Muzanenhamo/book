package artemas.demo.adapter.web.json

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class BookIsbnJson(
    @JsonProperty("isbnNumber")
    val isbnNumber: Long
)
