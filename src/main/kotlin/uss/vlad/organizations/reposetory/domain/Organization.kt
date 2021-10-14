package uss.vlad.organizations.reposetory.domain

import org.hibernate.Hibernate
import org.hibernate.annotations.Nationalized
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "organization")
data class Organization(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @Nationalized
    @Column(name = "org_name")
    var name: String? = null,

    @Nationalized
    @Column(name = "org_account")
    var account: String? = null,

    @Nationalized
    @Column(name = "legal_address")
    var legalAddress: String? = null,

    @Nationalized
    @Column(name = "org_status")
    var status: OrganizationStatus? = null,

    @Nationalized
    @Column(name = "time_created")
    var timeCreated: LocalDateTime? = null,

    @Nationalized
    @Column(name = "time_updated")
    var timeUpdated: LocalDateTime? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Organization

        return id != null && id == other.id
    }

    override fun hashCode(): Int = 0

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , legalAddress = $legalAddress )"
    }
}