package uss.vlad.organizations.service

import org.springframework.stereotype.Service
import uss.vlad.organizations.exception.NotFoundException
import uss.vlad.organizations.reposetory.OrganizationRepository
import uss.vlad.organizations.reposetory.domain.Organization

@Service
class OrganizationService(
    private val repository: OrganizationRepository
) {

    fun findById(orgId: Long): Organization =
        repository.findById(orgId).orElseThrow {
            throw NotFoundException("Organization with orgId $orgId not found")
        }

}