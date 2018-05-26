import java.time.Duration
import java.time.LocalDate

data class Movie (
        private val imdbID: String,
        private val title: String,
        private val releaseDate: LocalDate,
        private val genres: String,
        private val director: String,
        private val actors: List<String>,
        private val actresses: List<String>,
        private val duration: Duration ) {

    infix fun isReleasedIn(year: Int) = releaseDate.year == year

    infix fun hasDuration(minutes: Int) = duration.toMinutes() > minutes

    infix fun hasActor(actorName: String) = actors.contains(actorName)

    infix fun hasActress(actressName: String) = actresses.contains(actressName)

    infix fun isReleasedBetween(releaseDateRange: ClosedRange<LocalDate>) = releaseDate in releaseDateRange
}