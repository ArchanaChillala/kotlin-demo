import io.kotlintest.Description
import io.kotlintest.Spec
import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec
import java.time.Duration
import java.time.LocalDate

class MovieTest : FunSpec() {

    private lateinit var rangDe : Movie

    override fun beforeSpec(description: Description, spec: Spec) {
        super.beforeSpec(description, spec)
        rangDe = Movie("1234", "RangDe", LocalDate.of(2015, 12, 10) , "Comedy", "Director1", listOf("Aamir", "Kunal"), listOf("Sonal"), Duration.ofMinutes(200))
    }

    init {

        test("Should return true if release year of movie matches given year") {
            rangDe.isReleasedIn(2015) shouldBe true
        }

        test("Should return false if release year of movie does not match given year") {
            rangDe.isReleasedIn(2018) shouldBe false
        }

        test("Should return true if movie's duration is greater than the given minutes") {
            rangDe.hasDuration(180) shouldBe true
        }

        test("Should return false if movie's duration is lesser than the given minutes") {
            rangDe.hasDuration(250) shouldBe false
        }

        test("Should return true if given actor's name matches any of the movie's actors list") {
            rangDe.hasActor("Aamir") shouldBe true
        }

        test("Should return true if given actresses' name matches any of the movie's actresses list") {
            rangDe.hasActress("Sonal") shouldBe true
        }
    }
}