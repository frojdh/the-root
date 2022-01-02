package se.alluminate.helloworldservice

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InjectionPoint
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.reactive.CorsWebFilter
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource
import java.util.*

@Configuration
class HelloworldConfiguration {

    @Bean
    @Scope("prototype")
    fun logger(injectionPoint: InjectionPoint): Logger {
        return LoggerFactory.getLogger(
            injectionPoint.methodParameter?.containingClass // constructor
                ?:injectionPoint.field?.declaringClass) // or field injection
    }

    @Bean
    fun corsWebFilter(): CorsWebFilter? {
        val corsConfig = CorsConfiguration()
        corsConfig.allowedOrigins = Arrays.asList("*")
        corsConfig.maxAge = Long.MAX_VALUE
        corsConfig.addAllowedMethod("GET")
        corsConfig.addAllowedMethod("POST")
        corsConfig.addAllowedMethod("HEAD")
        corsConfig.addAllowedMethod("OPTIONS")
        corsConfig.addAllowedMethod("DELETE")
        corsConfig.addAllowedMethod("PUT")
        corsConfig.addAllowedHeader("*")
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", corsConfig)
        return CorsWebFilter(source)
    }
}