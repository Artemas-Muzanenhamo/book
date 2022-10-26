package artemas.demo.adapter.web.handler

import artemas.demo.adapter.web.exception.NotFoundException
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class EndpointErrorHandler {
    @ExceptionHandler
    fun handleBookIdNotFound(e: NotFoundException): ResponseEntity<String> {
        return ResponseEntity.status(BAD_REQUEST).body("An Invalid Book Id was supplied")
    }
}
