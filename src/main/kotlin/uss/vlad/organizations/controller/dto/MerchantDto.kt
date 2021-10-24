package uss.vlad.organizations.controller.dto

import io.swagger.annotations.ApiModel

@ApiModel
class MerchantDto(

    var name: String? = null,

    var address: String? = null,

    var organizationId: Long? = null
)