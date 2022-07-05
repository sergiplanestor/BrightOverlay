import org.gradle.api.tasks.Delete
import org.gradle.kotlin.dsl.register

buildscript {
  allprojects {
    tasks.register("clean-$name", Delete::class) {
      delete(buildDir)
    }
  }
}
