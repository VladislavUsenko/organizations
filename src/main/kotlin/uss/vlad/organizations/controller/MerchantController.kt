package uss.vlad.organizations.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.Authorization
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import uss.vlad.organizations.controller.dto.MerchantDto
import uss.vlad.organizations.controller.dto.Response
import uss.vlad.organizations.exception.NotFoundException
import uss.vlad.organizations.reposetory.domain.Status
import uss.vlad.organizations.service.MerchantService

@RestController
@RequestMapping("/api/merchant")
@Api(
    description = "Merchant management",
    tags = ["Merchant Controller"],
    authorizations = [Authorization(value = "basicAuth")]
)
class MerchantController(
    private val service: MerchantService
) {

    @ApiOperation(
        value = "Get a merchant by identifier",
        authorizations = [Authorization(value = "basicAuth")],
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @RequestMapping(
        value = ["/{id}"],
        method = [RequestMethod.GET]
    )
    @Throws(NotFoundException::class)
    fun getMerchantById(@PathVariable id: Long): Response =
        Response(
            status = HttpStatus.OK,
            data = service.findById(id)
        )

    @ApiOperation(
        value = "Get a merchants by organization's identifier",
        authorizations = [Authorization(value = "basicAuth")],
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @RequestMapping(
        value = ["by-org/{orgId}"],
        method = [RequestMethod.GET]
    )
    @Throws(NotFoundException::class)
    fun getMerchantByOrgId(@PathVariable orgId: Long): Response =
        Response(
            status = HttpStatus.OK,
            data = service.findByOrgId(orgId)
        )


    @ApiOperation(
        value = "Save new merchant",
        authorizations = [Authorization(value = "basicAuth")],
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @RequestMapping(
        value = ["/save"],
        method = [RequestMethod.POST]
    )
    @Throws(NotFoundException::class)
    fun saveMerchant(@RequestBody dto: MerchantDto): Response =
        Response(
            status = HttpStatus.OK,
            data = service.saveMerchant(dto)
        )

    @ApiOperation(
        value = "Update a merchant by identifier",
        authorizations = [Authorization(value = "basicAuth")],
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @RequestMapping(
        value = ["/{id}"],
        method = [RequestMethod.PUT]
    )
    @Throws(NotFoundException::class)
    fun updateMerchant(
        @PathVariable id: Long,
        @RequestBody dto: MerchantDto
    ): Response =
        Response(
            status = HttpStatus.OK,
            data = service.updateMerchant(id, dto)
        )

    @ApiOperation(
        value = "Update a merchant's status by identifier",
        authorizations = [Authorization(value = "basicAuth")],
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @RequestMapping(
        value = ["/{id}/{status}"],
        method = [RequestMethod.PUT]
    )
    @Throws(NotFoundException::class)
    fun updateStatus(
        @PathVariable id: Long,
        @PathVariable status: Status
    ): Response =
        Response(
            status = HttpStatus.OK,
            data = service.updateStatus(id, status)
        )

    @ApiOperation(
        value = "Update a orgId",
        authorizations = [Authorization(value = "basicAuth")],
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @RequestMapping(
        value = ["update-org-id/{id}/{orgId}"],
        method = [RequestMethod.PUT]
    )
    @Throws(NotFoundException::class)
    fun updateOrganization(
        @PathVariable id: Long,
        @PathVariable orgId: Long
    ): Response =
        Response(
            status = HttpStatus.OK,
            data = service.updateOrganizationId(id, orgId)
        )

    @ApiOperation(
        value = "Delete a merchant",
        authorizations = [Authorization(value = "basicAuth")],
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @RequestMapping(
        value = ["/{id}"],
        method = [RequestMethod.DELETE]
    )
    @Throws(NotFoundException::class)
    fun deleteMerchant(
        @PathVariable id: Long
    ): Response =
        Response(
            status = HttpStatus.OK,
            data = service.delete(id)
        )

}