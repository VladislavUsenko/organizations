package uss.vlad.organizations

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "app")
class AppProperties {

    var security: Security = Security()

    class Security {
        lateinit var login: String
        lateinit var pass: String
        var isEnabled: Boolean = true
    }
}