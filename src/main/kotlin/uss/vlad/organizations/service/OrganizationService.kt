package uss.vlad.organizations.service

import org.springframework.stereotype.Service
import uss.vlad.organizations.controller.dto.OrganizationDto
import uss.vlad.organizations.exception.NotFoundException
import uss.vlad.organizations.exception.OrganizationException
import uss.vlad.organizations.reposetory.OrganizationRepository
import uss.vlad.organizations.reposetory.domain.Organization
import uss.vlad.organizations.reposetory.domain.OrganizationStatus

@Service
class OrganizationService(
    private val repository: OrganizationRepository
) {

    fun findById(orgId: Long): Organization =
        repository.findById(orgId).orElseThrow {
            throw NotFoundException("Organization with orgId $orgId not found")
        }

    fun saveOrganization(dto: OrganizationDto): Long =
        repository.save(toDomain(dto)).id
            ?: throw OrganizationException("Organisation $dto didn't save!")

    fun toDomain(dto: OrganizationDto): Organization =
        Organization(
            name = dto.name,
            account = dto.account,
            legalAddress = dto.legalAddress
        )

    fun updateOrganization(id: Long, dto: OrganizationDto): Organization {
        val organization = findById(id)

        organization.name = dto.name
        organization.account = dto.account
        organization.legalAddress = dto.legalAddress

        return repository.save(organization)

    }

    fun updateStatus(id: Long, status: OrganizationStatus) {
        val organization = findById(id)
        organization.status = status
        repository.save(organization)
    }

    fun delete(id: Long) =
        repository.deleteById(id)

}