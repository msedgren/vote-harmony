package vote_harmony.voter

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column

data class Voter(
    @Id
    val id: Long,
    @Column()
    val externalId: Long,
    @Column()
    val name: String
) {
}
