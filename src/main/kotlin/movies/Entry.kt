package movies

import java.time.Duration
import java.time.LocalDate


fun main(args: Array<String>) {
    val rangDe = Movie("1234", "RangDe", LocalDate.of(2015, 12, 10), "Comedy", "Director1", listOf("Amir", "Kunal"), listOf("Sonal"), Duration.ofMinutes(180))
    val inferno = Movie("1234", "Inferno", LocalDate.of(2018, 10, 20), "Thriller", "Director1", listOf("Amir", "Kunal"), listOf("Sonal"), Duration.ofMinutes(136))

    val movieStore1 = MovieStore(mutableListOf(rangDe, inferno))

    println(movieStore1.getMoviesByActor("Amir"))
    println(movieStore1.findAllByReleaseDateIn(LocalDate.of(2016, 12, 12)..LocalDate.of(2019, 10, 15)))


    // MovieStore DSL

    val movieStore = MovieStore()

    movieStore {
        movie {
            title = "RangDe"
            imdbID = "1234"
            releaseDate = LocalDate.of(2015, 12, 10)
            genre = "Comedy"
        }
        movie {
            title = "Zootopia"
            imdbID = "5678"
            releaseDate = LocalDate.of(2018, 10, 20)
            genre = "Thriller"
        }
    }
}
