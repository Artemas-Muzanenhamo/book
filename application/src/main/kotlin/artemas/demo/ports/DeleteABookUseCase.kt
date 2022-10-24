package artemas.demo.ports

interface DeleteABookUseCase {
    fun deleteBy(isbnNumber: Long)
}
