package uss.vlad.organizations.controller.dto

import io.swagger.annotations.ApiModel


@ApiModel
class OrganizationDto(

    var name: String? = null,

    var account: String? = null,

    var legalAddress: String? = null,
)