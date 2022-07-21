package artemas.demo.adapter.persistence.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "book")
data class BookEntity(
    @Id
    val id: Long,
    val bookName: String,
    val isbnNumber: Long
)
