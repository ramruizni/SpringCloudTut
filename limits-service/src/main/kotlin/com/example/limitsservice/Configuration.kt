package com.example.limitsservice

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("limits-service")
class Configuration {
    var minimum: Int? = null
    var maximum: Int? = null
}