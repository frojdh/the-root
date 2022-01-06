package se.alluminate.helloworldservice

import org.slf4j.Logger
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.json

@Service
class HelloworldService (var log: Logger) {

    suspend fun hello(request: ServerRequest): ServerResponse =
        ServerResponse.ok().json().bodyValueAndAwait(HelloworldMessage("Hello Jon Doe!!"))

    suspend fun helloWithName(request: ServerRequest): ServerResponse =
        ServerResponse.ok().json().bodyValueAndAwait(HelloworldMessage("Hello " + request.pathVariable("name")))
}

data class HelloworldMessage(val message: String)