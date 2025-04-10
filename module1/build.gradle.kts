group = rootProject.group
version = rootProject.version


    dependencies {

            testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
            testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")

            // ✅ Add this:
            testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.0")

            implementation(project(":module2"))  // Add module2 as a dependency
    }
tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
