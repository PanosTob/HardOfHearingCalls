// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    val kotlinVersion by rootProject.extra { "1.7.0" }
    val hiltVersion by rootProject.extra { "2.43.1" }
    val navVersion by rootProject.extra { "2.5.1" }

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://www.jitpack.io")
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}