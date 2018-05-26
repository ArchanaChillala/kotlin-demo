package movies

import java.time.LocalDate

class MovieStore(private val movieList: MutableList<Movie> = mutableListOf()) {

    fun getMoviesByReleaseYear(year: Int) = movieList.filter { it isReleasedIn year }

    fun getMoviesByDuration(minutes: Int) = movieList.filter { it hasDuration minutes }

    fun getMoviesByActor(actorName: String) = movieList.filter { it hasActor actorName }

    fun getMoviesByActress(actressName: String) = movieList.filter { it hasActress actressName }

    fun findAllByReleaseDateIn(releaseDateRange: ClosedRange<LocalDate>) = movieList.filter { it isReleasedBetween releaseDateRange }

    operator fun invoke(action: MovieStore.() -> Unit): MovieStore {
        action()
        return this
    }

    fun movie(action: Movie.() -> Unit) {
        val movie = Movie()
        movie.action()
    }
}

