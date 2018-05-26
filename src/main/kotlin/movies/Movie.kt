package movies

import java.time.Duration
import java.time.LocalDate

data class Movie(
        internal var imdbID: String = "",
        internal var title: String = "",
        internal var releaseDate: LocalDate = LocalDate.now(),
        internal var genre: String = "",
        private val director: String = "",
        private val actors: List<String> = listOf(),
        private val actresses: List<String> = listOf(),
        private val duration: Duration = Duration.ofMinutes(120)) {

    infix fun isReleasedIn(year: Int) = releaseDate.year == year

    infix fun hasDuration(minutes: Int) = duration.toMinutes() > minutes

    infix fun hasActor(actorName: String) = actors.contains(actorName)

    infix fun hasActress(actressName: String) = actresses.contains(actressName)

    infix fun isReleasedBetween(releaseDateRange: ClosedRange<LocalDate>) = releaseDate in releaseDateRange
}