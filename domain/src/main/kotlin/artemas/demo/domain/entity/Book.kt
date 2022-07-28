package artemas.demo.domain.entity

import org.hibernate.Hibernate
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Book(
    @Id
    val id: Long,
    val bookName: String,
    val isbnNumber: Long
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Book

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , bookName = $bookName , isbnNumber = $isbnNumber )"
    }
}
