package vote_harmony.issue

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface IssueRepository: ReactiveCrudRepository<Issue, Long> {
}
