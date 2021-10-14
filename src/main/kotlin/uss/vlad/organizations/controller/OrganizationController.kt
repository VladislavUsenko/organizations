package uss.vlad.organizations.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.Authorization
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import uss.vlad.organizations.exception.NotFoundException
import uss.vlad.organizations.reposetory.domain.Organization
import uss.vlad.organizations.service.OrganizationService

@RestController
@RequestMapping("/api/organization")
@Api(
        description = "Organization management",
        tags = ["Organization Controller"]
)
class OrganizationController(
        private val service: OrganizationService
) {

    @ApiOperation(
            value = "Getting an organization by identifier",
            authorizations = [Authorization(value = "basicAuth")],
            produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(
            value = ["/{id}"],
            method = [RequestMethod.GET])
    @Throws(NotFoundException::class)
    fun getOrganizationById(@PathVariable id: Long): Organization =
            service.findById(id)

}