import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.3.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    war
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"
    kotlin("plugin.jpa") version "1.3.72"
}

group = "com.jun"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
//		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        exclude(module = "junit")
    }

    // JUnit
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0-M1")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.4.0-rc")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0-M1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.0-M1")
    testImplementation("org.assertj:assertj-core:3.16.1")
    implementation("org.junit.platform:junit-platform-commons:1.7.0-M1")

    // Logger
    implementation("org.slf4j:slf4j-api:1.7.30")

    // MariaDB
    implementation("org.mariadb.jdbc:mariadb-java-client:2.6.2")

    // Model Mapper
//    implementation("org.modelmapper.extensions:modelmapper-spring:2.3.8")
    implementation("org.modelmapper:modelmapper:2.3.8")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
