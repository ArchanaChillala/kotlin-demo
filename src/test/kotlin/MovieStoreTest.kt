import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec
import java.time.Duration
import java.time.LocalDate

class MovieStoreTest : FunSpec() {

    init {

        val rangDe = Movie("1234", "RangDe", LocalDate.of(2015, 12, 10) , "Comedy", "Director1", listOf("Aamir", "Kunal"), listOf("Sonal"), Duration.ofMinutes(200))
        val zootopia = Movie("5678", "Zootopia", LocalDate.of(2018, 12, 10) , "Disney", "Director1", listOf("Amir", "Kunal"), listOf("Julia"), Duration.ofMinutes(120))
        val movieStore = MovieStore(mutableListOf(rangDe, zootopia))

        test("Should return movies based on a release year") {
            movieStore.getMoviesByReleaseYear(2018) shouldBe listOf(zootopia)
        }

        test("Should return movies based on duration of the movie") {
            movieStore.getMoviesByDuration(150) shouldBe listOf(rangDe)
        }

        test("Should return movies based on actor's name") {
            movieStore.getMoviesByActor("Aamir") shouldBe listOf(rangDe)
        }

        test("Should return movies based on actress' name") {
            movieStore.getMoviesByActress("Julia") shouldBe listOf(zootopia)
        }
    }
}