plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.plavsic.skytrace"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.plavsic.skytrace"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String","AVIATION_EDGE_API_KEY","\"${project.findProperty("AVIATION_EDGE_API_KEY")}\"")
        buildConfigField("String","OPEN_WEATHER_MAP_API_KEY","\"${project.findProperty("OPEN_WEATHER_MAP_API_KEY")}\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        android.buildFeatures.buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {


    implementation(libs.hilt.android) // DI
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.play.services.maps)
    kapt(libs.hilt.android.compiler) // DI
    implementation(libs.android)     // mapbox sdk
    implementation(libs.maps.compose) // mapbox compose sdk
    implementation(libs.coil.compose) // coil for images
    implementation(libs.retrofit) // retrofit for api
    implementation(libs.converter.gson) // gson serialization
    implementation(libs.androidx.lifecycle.viewmodel.compose) // viewModel
    implementation(libs.androidx.navigation.compose) // Navigation
    implementation(libs.play.services.location) // google location
    implementation(libs.accompanist.permissions) // permissions library

    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    // OVO MI NE TREBA
//    implementation(libs.androidx.material) // Proveri najnoviju verziju
    implementation(libs.androidx.material.icons.extended)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(kotlin("script-runtime"))
}

kapt {
    correctErrorTypes = true
}