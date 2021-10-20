package uss.vlad.organizations.controller.dto

import org.springframework.http.HttpStatus

class Response(
    val status: HttpStatus,
    val message: String? = null,
    val data: Any? = null
)