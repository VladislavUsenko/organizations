package uss.vlad.organizations.configuration

import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class CustomAuthEntryPoint : AuthenticationEntryPoint {

    @Throws(IOException::class, ServletException::class)
    override fun commence(request: HttpServletRequest?,
                          response: HttpServletResponse,
                          authException: AuthenticationException?) {

        response.addHeader("WWW-Authenticate", "Basic realm")
        response.status = HttpServletResponse.SC_UNAUTHORIZED
        val writer = response.writer
        writer.println("HTTP Status 401 - " + authException!!.message)
    }
}