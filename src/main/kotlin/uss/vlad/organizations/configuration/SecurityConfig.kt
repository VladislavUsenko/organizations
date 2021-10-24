package uss.vlad.organizations.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import uss.vlad.organizations.AppProperties

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val appProperties: AppProperties,
    private val authenticationEntryPoint: CustomAuthEntryPoint
) : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {

        http.authorizeRequests()
            .antMatchers(*AUTH_WHITELIST).permitAll()

        if (appProperties.security.isEnabled) {
            http.authorizeRequests()
                .antMatchers("/**/*").authenticated()
        } else {
            http.authorizeRequests().antMatchers("/**/*").permitAll()
        }
        http.csrf().disable().httpBasic().authenticationEntryPoint(authenticationEntryPoint)

    }

    @Autowired
    @Throws(Exception::class)
    internal fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .withUser(appProperties.security.login)
            .password(passwordEncoder().encode(appProperties.security.pass))
            .authorities("SWAGGER")
    }

    @Bean
    internal fun passwordEncoder() = BCryptPasswordEncoder()


    companion object {
        private val AUTH_WHITELIST = arrayOf(
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/v2/api-docs",
            "/webjars/**"
        )
    }
}