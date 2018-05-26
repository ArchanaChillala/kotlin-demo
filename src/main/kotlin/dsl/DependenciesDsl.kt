package dsl

class DependenciesDsl {

    private val compile = mutableListOf<CompileConfiguration>()
    private val testCompile = mutableListOf<CompileConfiguration>()

    fun compile(coordinate: String) {
        compile += CompileConfiguration(coordinate)
    }

    fun testCompile(coordinate: String) {
        testCompile += CompileConfiguration(coordinate)
    }

    fun findAllCompile() = compile.toList()

    operator fun invoke(action: DependenciesDsl.() -> Unit ) : DependenciesDsl {
        action()
        return this
    }
}

class CompileConfiguration(val coordinate: String)
