plugins {
	application
}

repositories {
	mavenCentral()
}

dependencies {
	// This dependency is used by the application.
	implementation("com.google.guava:guava:30.1.1-jre")

	testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

	implementation("org.apache.logging.log4j:log4j-api:2.18.0")
	implementation("org.apache.logging.log4j:log4j-core:2.18.0")
}

application {
	mainClass.set("mpl.Main")
}

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(17))
	}
}

tasks.test {
	// Use the built-in JUnit support of Gradle.
	useJUnitPlatform()
}
