package uss.vlad.organizations.reposetory

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import uss.vlad.organizations.reposetory.domain.Merchant

@Repository
interface MerchantRepository : JpaRepository<Merchant, Long> {

    fun findAllByOrganizationId(orgId: Long): List<Merchant>?
}