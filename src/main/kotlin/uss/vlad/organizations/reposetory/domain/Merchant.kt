package uss.vlad.organizations.reposetory.domain

import org.hibernate.Hibernate
import org.hibernate.annotations.Nationalized
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "merchant")
data class Merchant(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @Nationalized
    @Column(name = "name")
    var name: String? = null,

    @Nationalized
    @Column(name = "address")
    var address: String? = null,

    @Column(name = "status")
    var status: Status? = Status.ENABLED,

    @Column(name = "org_id")
    var organizationId: Long? = null,

    @Column(name = "time_created")
    var timeCreated: LocalDateTime? = null,

    @Column(name = "time_updated")
    var timeUpdated: LocalDateTime? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Merchant

        return id != null && id == other.id
    }

    override fun hashCode(): Int = 0

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , organizationId = $organizationId )"
    }
}


