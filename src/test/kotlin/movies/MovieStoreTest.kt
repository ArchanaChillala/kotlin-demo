package movies

import io.kotlintest.Description
import io.kotlintest.Spec
import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec
import java.time.Duration
import java.time.LocalDate

class MovieStoreTest : FunSpec() {

    private lateinit var rangDe: Movie
    private lateinit var zootopia: Movie
    private lateinit var movieStore: MovieStore

    override fun beforeSpec(description: Description, spec: Spec) {
        super.beforeSpec(description, spec)

        rangDe = Movie("1234", "RangDe", LocalDate.of(2015, 12, 10), "Comedy", "Director1", listOf("Aamir", "Kunal"), listOf("Sonal"), Duration.ofMinutes(200))
        zootopia = Movie("5678", "Zootopia", LocalDate.of(2018, 12, 10), "Disney", "Director1", listOf("Amir", "Kunal"), listOf("Julia"), Duration.ofMinutes(120))
        movieStore = MovieStore(mutableListOf(rangDe, zootopia))
    }

    init {

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

        test("Should return all movies released between a given date range") {
            movieStore.findAllByReleaseDateIn(LocalDate.of(2014, 12, 12)..LocalDate.of(2019, 10, 15)) shouldBe listOf(rangDe, zootopia)
            movieStore.findAllByReleaseDateIn(LocalDate.of(2016, 12, 12)..LocalDate.of(2019, 10, 15)) shouldBe listOf(zootopia)
            movieStore.findAllByReleaseDateIn(LocalDate.of(2014, 12, 12)..LocalDate.of(2016, 10, 15)) shouldBe listOf(rangDe)
            movieStore.findAllByReleaseDateIn(LocalDate.of(2012, 12, 12)..LocalDate.of(2014, 10, 15)) shouldBe listOf()
        }
    }
}