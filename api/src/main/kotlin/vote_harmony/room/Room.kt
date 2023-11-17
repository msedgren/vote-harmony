package vote_harmony.room

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import java.util.UUID

data class Room(
    @Id
    val id: Long?,
    @Column
    val externalId: UUID?,
    @Column
    val name: String,
    @Column
    val description: String) {
}
