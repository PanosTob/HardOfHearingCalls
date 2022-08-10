plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id ("androidx.navigation.safeargs")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "gr.dipae.hardofhearingcalls"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isDebuggable = true
        }
        release {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    sourceSets {
        getByName("main") {
            assets {
                srcDirs("src/main/assets")
            }
        }
    }

    applicationVariants.all {
        outputs.all {
            val output = (this as com.android.build.gradle.internal.api.BaseVariantOutputImpl)
            output.outputFileName = "${flavorName}_${versionName}_Hard_Of_Hearing_Calls_${buildType.name}.apk"
        }
    }
}

dependencies {

    val composeVersion by extra { "1.2.0" }
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.camera:camera-view:1.1.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    implementation("androidx.fragment:fragment-ktx:1.5.1")

    implementation("androidx.navigation:navigation-fragment-ktx:${rootProject.extra.get("navVersion")}")
    implementation("androidx.navigation:navigation-ui-ktx:${rootProject.extra.get("navVersion")}")
    implementation("androidx.navigation:navigation-dynamic-features-fragment:${rootProject.extra.get("navVersion")}")

    val lifecycle_version by extra { "2.5.0" }
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")

    val compose_version by extra { "1.2.0" }
    implementation("androidx.compose.ui:ui:$compose_version")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:$compose_version")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:$compose_version")
    // Material Design
    implementation("androidx.compose.material:material:$compose_version")
    // Integration with activities
    implementation("androidx.activity:activity-compose:1.5.1")
    // Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    // Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:$compose_version")
    // Constrain layout for compose
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    implementation("com.google.dagger:hilt-android:${rootProject.extra.get("hiltVersion")}")
    kapt("com.google.dagger:hilt-android-compiler:${rootProject.extra.get("hiltVersion")}")

    implementation("androidx.browser:browser:1.4.0")

    val accompanist_version by extra { "0.25.0" }
    implementation("com.google.accompanist:accompanist-pager:$accompanist_version")
    implementation("com.google.accompanist:accompanist-pager-indicators:$accompanist_version")
    implementation("com.google.accompanist:accompanist-swiperefresh:$accompanist_version")
    implementation("com.google.accompanist:accompanist-flowlayout:$accompanist_version")

    val jitsiVersion by extra { "6.0.0" }
    implementation("org.jitsi.react:jitsi-meet-sdk:$jitsiVersion") { isTransitive = true }
}