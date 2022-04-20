plugins {
    application
    kotlin("jvm")                              version "1.6.20"
    kotlin("plugin.spring")                    version "1.6.20"
    id("org.springframework.boot")             version "2.6.6"
    id("io.spring.dependency-management")      version "1.0.11.RELEASE"
    id("org.springframework.experimental.aot") version "0.10.4"
}

repositories {
    mavenCentral()
    maven(uri("https://repo.spring.io/release"))
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.springframework.boot:spring-boot-starter-webflux")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

application {
    mainClass.set("springrestapi.MainKt")
}

springAot {
    removeXmlSupport.set(true)
    removeSpelSupport.set(true)
    removeYamlSupport.set(true)
    removeJmxSupport.set(true)
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootBuildImage> {
    builder = "paketobuildpacks/builder:tiny"
    environment = mapOf("BP_NATIVE_IMAGE" to "1", "BP_JVM_VERSION" to "17", "BP_BINARY_COMPRESSION_METHOD" to "upx")
}
