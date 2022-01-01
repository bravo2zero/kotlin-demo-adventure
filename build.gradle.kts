plugins {
    java
    kotlin("jvm") version "1.6.10"
}

repositories {
    mavenCentral()
}

java{
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}
