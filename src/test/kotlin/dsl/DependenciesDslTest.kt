package dsl

import io.kotlintest.specs.FunSpec

class DependenciesDslTest : FunSpec() {

    init{

        test("should use dependenciesDsl") {
            val dependencies = DependenciesDsl()

            dependencies {
                compile("abc")
                testCompile("efg")
            }
        }
    }
}


