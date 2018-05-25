import java.time.Duration
import java.time.LocalDate


fun main(args: Array<String>) {
    val rangDe = Movie("1234", "RangDe", LocalDate.of(2015, 12, 10) , "Comedy", "Director1", listOf("Amir", "Kunal"), listOf("Sonal"), Duration.ofMinutes(180))
    val inferno = Movie("1234", "Inferno", LocalDate.of(2018, 10, 20) , "Thriller", "Director1", listOf("Amir", "Kunal"), listOf("Sonal"), Duration.ofMinutes(136))

    val movieStore = MovieStore(mutableListOf(rangDe, inferno))

    println(movieStore.getMoviesByActor("Amir"))
}
