package vote_harmony.room

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.reactive.TransactionalOperator
import reactor.core.publisher.Mono
import java.util.*

@Service
@Transactional
class RoomService(private val roomRepository: RoomRepository) {

    fun findByExternalId(id: UUID): Mono<RoomDto> {
        return roomRepository.findRoomByExternalId(id)
            .map { RoomDto(it.externalId!!, it.name, it.description) }
    }

    fun create(room: RoomDto): Mono<RoomDto> {
        return roomRepository.save(Room(null, null, room.name, room.description))
            .map { RoomDto(it.externalId!!, it.name, it.description) }
    }

    fun update(room: RoomDto): Mono<RoomDto> {
        return roomRepository.findRoomByExternalId(room.id)
            .map { it.copy(name = room.name, description = room.description) }
            .flatMap { roomRepository.save(it) }
            .map { RoomDto(it.externalId!!, it.name, it.description) }
    }

    fun deleteAll(): Mono<Void> {
        return roomRepository.deleteAll()
    }
}
