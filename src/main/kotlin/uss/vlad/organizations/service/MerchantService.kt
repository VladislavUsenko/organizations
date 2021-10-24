package uss.vlad.organizations.service

import org.springframework.stereotype.Service
import uss.vlad.organizations.controller.dto.MerchantDto
import uss.vlad.organizations.exception.NotFoundException
import uss.vlad.organizations.exception.OrganizationException
import uss.vlad.organizations.reposetory.MerchantRepository
import uss.vlad.organizations.reposetory.domain.Merchant
import uss.vlad.organizations.reposetory.domain.Status

@Service
class MerchantService(
    private val repository: MerchantRepository
) {

    fun findById(merchId: Long): Merchant =
        repository.findById(merchId).orElseThrow {
            throw NotFoundException("Merchant with Id $merchId not found")
        }

    fun findByOrgId(orgId: Long): List<Merchant>? =
        repository.findAllByOrganizationId(orgId)

    fun saveMerchant(dto: MerchantDto): Long =
        repository.save(toDomain(dto)).id
            ?: throw OrganizationException("Organisation $dto didn't save!")

    fun toDomain(dto: MerchantDto): Merchant =
        Merchant(
            name = dto.name,
            address = dto.address,
            organizationId = dto.organizationId
        )

    fun updateMerchant(id: Long, dto: MerchantDto): Merchant {
        val merchant = findById(id)

        merchant.name = dto.name
        merchant.address = dto.address

        return repository.save(merchant)

    }

    fun updateStatus(id: Long, status: Status) {
        val merchant = findById(id)
        merchant.status = status
        repository.save(merchant)
    }

    fun updateOrganizationId(id: Long, orgId: Long) {
        val merchant = findById(id)
        merchant.organizationId = orgId
        repository.save(merchant)
    }

    fun delete(id: Long) =
        repository.deleteById(id)

}