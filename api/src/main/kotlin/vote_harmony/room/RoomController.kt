package vote_harmony.room

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.UUID

@RestController("/room")
class RoomController(val roomService: RoomService) {


    @GetMapping(value = ["", "/"])
    fun findById(id: UUID): Mono<ResponseEntity<RoomDto>> {
        return roomService.findByExternalId(id)
            .map { ResponseEntity.ok(it) }
            .or(Mono.defer { Mono.just(ResponseEntity.notFound().build()) })
    }

    @PostMapping(value = ["", "/"])
    fun create(@RequestBody room: RoomDto): Mono<ResponseEntity<RoomDto>> {
        return roomService.create(room)
            .map { ResponseEntity.ok(it) }
    }

    @PutMapping(value = ["/{id}"])
    fun update(@RequestBody room: RoomDto, id: UUID): Mono<ResponseEntity<RoomDto>> {
        return if (room.id != id)
            Mono.just(ResponseEntity.badRequest().build())
        else
            roomService.update(room)
                .map { ResponseEntity.ok(it) }
                .or(Mono.defer { Mono.just(ResponseEntity.notFound().build()) })

    }
}
