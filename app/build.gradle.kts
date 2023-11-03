plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.juctionldn.tomtomexample"
    compileSdk = 34
    buildToolsVersion = "34.0.0"

    defaultConfig {
        applicationId = "com.juctionldn.tomtomexample"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "0.1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField(
            "String",
            "TOMTOM_API_KEY",
            "\"${providers.gradleProperty("tomtomApiKey").get()}\""
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    dependenciesInfo {
        includeInApk = true
        includeInBundle = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
        jniLibs.pickFirsts.add("lib/**/libc++_shared.so")
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // TomTom
    val tomtomVersion = "0.33.1"
    implementation("com.tomtom.sdk.maps:map-display:$tomtomVersion")
    implementation("com.tomtom.sdk.location:provider-simulation:$tomtomVersion")
    implementation("com.tomtom.sdk.location:provider-android:$tomtomVersion")
    implementation("com.tomtom.sdk.location:provider-map-matched:$tomtomVersion")
    implementation("com.tomtom.sdk.location:provider-android:$tomtomVersion")
    implementation("com.tomtom.sdk.navigation:navigation-online:$tomtomVersion")
    implementation("com.tomtom.sdk.navigation:route-replanner-online:$tomtomVersion")
    implementation("com.tomtom.sdk.navigation:ui:$tomtomVersion")
    implementation("com.tomtom.sdk.routing:route-planner-online:$tomtomVersion")

    // GPX Parser
    implementation("com.github.ticofab:android-gpx-parser:2.3.1")

    // timber
    implementation("com.jakewharton.timber:timber:5.0.1")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}