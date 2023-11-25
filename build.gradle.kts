import nl.javadude.gradle.plugins.license.LicenseExtension
import java.util.*

plugins {
	java
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
	id("com.github.hierynomus.license") version "0.16.1"
}

group = "com.github.timtebeek"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

configure<LicenseExtension> {
	ext.set("year", Calendar.getInstance().get(Calendar.YEAR))
	skipExistingHeaders = true
	header = project.rootProject.file("gradle/licenseHeader.txt")
	mapping(mapOf("kt" to "SLASHSTAR_STYLE", "java" to "SLASHSTAR_STYLE"))
	strictCheck = true
	exclude("**/versions.properties")
	exclude("**/*.txt")
}
