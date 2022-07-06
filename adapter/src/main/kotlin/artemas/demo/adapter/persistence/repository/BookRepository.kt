package artemas.demo.adapter.persistence.repository

import artemas.demo.adapter.persistence.entity.BookEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: CrudRepository<BookEntity, Long>