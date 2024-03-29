package artemas.demo.service

import artemas.demo.ports.DeleteABookPort
import artemas.demo.ports.DeleteABookUseCase
import org.springframework.stereotype.Service

@Service
class DeleteABookService(private val deleteABookPort: DeleteABookPort): DeleteABookUseCase {
    override fun deleteBy(id: Long) {
        return deleteABookPort.by(id)
    }
}
