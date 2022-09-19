plugins {
	java
	application
	eclipse
}

repositories {
	mavenCentral()
}

dependencies {
	// This dependency is used by the application.
	implementation("com.google.guava:guava:31.0.1-jre")

	//JUnit
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
	testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
	testImplementation("com.google.truth:truth:1.1.3")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")

	//Spring boot
	implementation(platform("org.springframework.boot:spring-boot-dependencies:2.7.3"))
	implementation("org.springframework.boot:spring-boot-starter")    
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.3")
	implementation("org.springframework.boot:spring-boot-starter-log4j2:2.7.3")

	//do not use spring logger
    modules {
        module("org.springframework.boot:spring-boot-starter-logging") {
            replacedBy("org.springframework.boot:spring-boot-starter-log4j2", "Use Log4j2 instead of Logback")
        }
    }

	//log4j2
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

    //filter{
	//	excludeTestsMatching("*fixed*")
	//}
}
