package vote_harmony.vote

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface VoteRepository: ReactiveCrudRepository<Vote, Long> {
}
