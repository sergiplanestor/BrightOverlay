import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope

enum class DependencyImport(val type: String) {
  Implementation("implementation"),
  Api("api"),
  Kapt("kapt"),
  AnnotationProcessor("annotationProcessor"),
  TestImplementation("testImplementation"),
  AndroidTestImplementation("androidTestImplementation"),
}

data class Dependency(
  val id: String,
  val import: DependencyImport = DependencyImport.Implementation
)

sealed class DependencyHandlerScopeWrapper(open val handler: DependencyHandlerScope) {
  data class Impl(override val handler: DependencyHandlerScope) : DependencyHandlerScopeWrapper(handler)
  data class Api(override val handler: DependencyHandlerScope) : DependencyHandlerScopeWrapper(handler)
  data class Kapt(override val handler: DependencyHandlerScope) : DependencyHandlerScopeWrapper(handler)
  data class TestImpl(override val handler: DependencyHandlerScope) : DependencyHandlerScopeWrapper(handler)
  data class AndroidTestImpl(override val handler: DependencyHandlerScope) : DependencyHandlerScopeWrapper(handler)
  data class AnnotationProcessor(override val handler: DependencyHandlerScope) : DependencyHandlerScopeWrapper(handler)
}
operator fun DependencyHandlerScopeWrapper.plusAssign(id: String) {
  when(this) {
    is DependencyHandlerScopeWrapper.Api -> handler.api(id)
    is DependencyHandlerScopeWrapper.Impl -> handler.add(id)
    is DependencyHandlerScopeWrapper.Kapt -> handler.kapt(id)
    is DependencyHandlerScopeWrapper.TestImpl -> handler.testImpl(id)
    is DependencyHandlerScopeWrapper.AndroidTestImpl -> handler.androidTestImpl(id)
    is DependencyHandlerScopeWrapper.AnnotationProcessor -> handler.annotationProcessor(id)
  }
}

val DependencyHandlerScope.libs: DependencyHandlerScope get() = this
val DependencyHandlerScope.impl: DependencyHandlerScopeWrapper get() = DependencyHandlerScopeWrapper.Impl(this)
val DependencyHandlerScope.api: DependencyHandlerScopeWrapper get() = DependencyHandlerScopeWrapper.Api(this)
val DependencyHandlerScope.kapt: DependencyHandlerScopeWrapper get() = DependencyHandlerScopeWrapper.Kapt(this)
val DependencyHandlerScope.unitTest: DependencyHandlerScopeWrapper get() = DependencyHandlerScopeWrapper.TestImpl(this)
val DependencyHandlerScope.integrationTest: DependencyHandlerScopeWrapper get() = DependencyHandlerScopeWrapper.AndroidTestImpl(this)
val DependencyHandlerScope.annotationProcessor : DependencyHandlerScopeWrapper get() = DependencyHandlerScopeWrapper.AnnotationProcessor(this)


operator fun DependencyHandlerScope.plusAssign(dependency: Dependency) {
  add(dependency.import.type, dependency.id)
}

operator fun DependencyHandlerScope.plusAssign(id: String) {
  libs += Dependency(id)
}

infix fun DependencyHandlerScope.add(id: String) {
  libs += id
}

infix fun DependencyHandlerScope.api(id: String) {
  libs += Dependency(id, DependencyImport.Api)
}

infix fun DependencyHandlerScope.kapt(id: String) {
  libs += Dependency(id, DependencyImport.Kapt)
}

infix fun DependencyHandlerScope.testImpl(id: String) {
  libs += Dependency(id, DependencyImport.TestImplementation)
}

infix fun DependencyHandlerScope.androidTestImpl(id: String) {
  libs += Dependency(id, DependencyImport.AndroidTestImplementation)
}

infix fun DependencyHandlerScope.annotationProcessor(id: String) {
  libs += Dependency(id, DependencyImport.AnnotationProcessor)
}

fun Project.isApp(): Boolean =
  name == "app"