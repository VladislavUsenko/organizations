package uss.vlad.organizations.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.Authorization
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import uss.vlad.organizations.controller.dto.OrganizationDto
import uss.vlad.organizations.controller.dto.Response
import uss.vlad.organizations.exception.NotFoundException
import uss.vlad.organizations.reposetory.domain.Organization
import uss.vlad.organizations.reposetory.domain.OrganizationStatus
import uss.vlad.organizations.service.OrganizationService

@RestController
@RequestMapping("/api/organization")
@Api(
    description = "Organization management",
    tags = ["Organization Controller"],
    authorizations = [Authorization(value = "basicAuth")]
)
class OrganizationController(
    private val service: OrganizationService
) {

    @ApiOperation(
        value = "Get an organization by identifier",
        authorizations = [Authorization(value = "basicAuth")],
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @RequestMapping(
        value = ["/{id}"],
        method = [RequestMethod.GET]
    )
    @Throws(NotFoundException::class)
    fun getOrganizationById(@PathVariable id: Long): Response =
        Response(
            status = HttpStatus.OK,
            data = service.findById(id)
        )


    @ApiOperation(
        value = "Save new organization",
        authorizations = [Authorization(value = "basicAuth")],
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @RequestMapping(
        value = ["/save"],
        method = [RequestMethod.POST]
    )
    @Throws(NotFoundException::class)
    fun saveOrganization(@RequestBody dto: OrganizationDto): Response =
        Response(
            status = HttpStatus.OK,
            data = service.saveOrganization(dto)
        )

    @ApiOperation(
        value = "Update an organization by identifier",
        authorizations = [Authorization(value = "basicAuth")],
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @RequestMapping(
        value = ["/{id}"],
        method = [RequestMethod.PUT]
    )
    @Throws(NotFoundException::class)
    fun updateOrganization(
        @PathVariable id: Long,
        @RequestBody dto: OrganizationDto
    ): Response =
        Response(
            status = HttpStatus.OK,
            data = service.updateOrganization(id, dto)
        )

    @ApiOperation(
        value = "Update an organization's status by identifier",
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
        @PathVariable status: OrganizationStatus
    ): Response =
        Response(
            status = HttpStatus.OK,
            data = service.updateStatus(id, status)
        )

    @ApiOperation(
        value = "Delete an organization",
        authorizations = [Authorization(value = "basicAuth")],
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @RequestMapping(
        value = ["/{id}"],
        method = [RequestMethod.DELETE]
    )
    @Throws(NotFoundException::class)
    fun deleteOrganization(
        @PathVariable id: Long
    ): Response =
        Response(
            status = HttpStatus.OK,
            data = service.delete(id)
        )

}