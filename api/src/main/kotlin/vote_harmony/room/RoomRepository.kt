package vote_harmony.room

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono
import java.util.*

interface RoomRepository: ReactiveCrudRepository<Room, Long> {

    fun findRoomByExternalId(externalId: UUID): Mono<Room>;
}
