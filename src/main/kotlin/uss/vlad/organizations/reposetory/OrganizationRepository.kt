package uss.vlad.organizations.reposetory

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import uss.vlad.organizations.reposetory.domain.Organization

@Repository
interface OrganizationRepository: JpaRepository<Organization, Long>
