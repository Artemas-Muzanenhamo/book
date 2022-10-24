package artemas.demo.ports

interface DeleteABookPort {
    fun by(isbnNumber: Long)
}
