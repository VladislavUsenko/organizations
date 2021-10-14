package uss.vlad.organizations.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.BasicAuth
import springfox.documentation.service.Contact
import springfox.documentation.service.SecurityScheme
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.ArrayList

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration::class)
open class SwaggerConfig {

    @Bean
    open fun api(): Docket {

        val schemeList = ArrayList<SecurityScheme>()
        schemeList.add(BasicAuth("basicAuth"))

        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("uss.vlad.organization"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                .securitySchemes(schemeList)
    }

    private fun getApiInfo(): ApiInfo {
        return ApiInfo(
                "Organization API",
                "this API: \n" +
                        "* service for Organization. \n",
                "0.1.0",
                "",
                Contact("Ussenko Vladislav", "", "your@mail.com"),
                "",
                "",
                emptyList()
        )
    }
}