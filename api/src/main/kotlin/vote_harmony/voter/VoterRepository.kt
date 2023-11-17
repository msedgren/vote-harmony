package vote_harmony.voter

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface VoterRepository: ReactiveCrudRepository<Voter, Long> {
}
