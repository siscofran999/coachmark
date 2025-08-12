import java.util.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.sisco.coachmark"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("com.google.android.material:material:1.10.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
}

// Baca local.properties
val localProperties = Properties().apply {
    val file = rootProject.file("local.properties")
    if (file.exists()) {
        load(file.inputStream())
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.siscofran999"
            artifactId = "coachmark"
            version = "0.9"
            artifact("$buildDir/outputs/aar/coachmark-release.aar")
        }
    }

    repositories {
        maven {
            name = "github"
            url = uri("https://maven.pkg.github.com/siscofran999/coachmark")
            credentials {
                username = localProperties.getProperty("username") ?: ""
                password = localProperties.getProperty("password") ?: ""
            }
        }
    }
}