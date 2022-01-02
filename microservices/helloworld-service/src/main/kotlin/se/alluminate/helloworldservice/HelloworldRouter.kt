package se.alluminate.helloworldservice

import kotlinx.coroutines.FlowPreview
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class HelloworldRouter {

    @FlowPreview
    @Bean
    fun helloworldRoutes(helloworldService: HelloworldService) = coRouter {
        GET("/", helloworldService::hello)
        GET("/{name}", helloworldService::helloWithName)
    }
}