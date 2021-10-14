package uss.vlad.organizations.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.view.RedirectView
import springfox.documentation.annotations.ApiIgnore

@Controller
@RequestMapping("/")
@ApiIgnore
@ControllerAdvice
class MainController {

    @GetMapping("/")
    fun rootToSwaggerUiRedirect() =
         RedirectView("/swagger-ui/index.html")

}