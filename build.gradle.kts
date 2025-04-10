import buildutils.configureDetekt
import buildutils.createDetektTask
import buildutils.configureDiktat
import buildutils.createDiktatTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("DSL_SCOPE_VIOLATION")
plugins {

    id(libs.plugins.kotlin.jvm.get().pluginId)
    alias(libs.plugins.buildconfig) apply true
}

group = "org.example"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }

    // Configure tasks for all projects
    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
}

subprojects {
    // Apply these only to subprojects
    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
        testRuntimeOnly("org.junit.platform:junit-platform-console:1.9.0")
    }

    configureDiktat()
    configureDetekt()
}

createDiktatTask()
createDetektTask()