plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("org.jetbrains.kotlin.kapt")

}

android {
    namespace = "com.example.devflix"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.devflix"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    kapt {
        correctErrorTypes = true // Habilite a correção de tipos de erro
        useBuildCache = true // Use o cache de construção para acelerar o processo
        arguments {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }

    buildTypes {

        release {
//            buildConfigField("String", "OMDB_API_KEY", "\"${project.property("OMDB_API_KEY")}\"")
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
        viewBinding = true
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

    implementation(libs.androidx.core.ktx.v190)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout.v214)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Navigation Component
    implementation(libs.androidx.navigation.fragment.ktx.v270)
    implementation(libs.androidx.navigation.ui.ktx.v270)
    implementation(libs.androidx.navigation.fragment)

    //Glade
    implementation(libs.glide)
    annotationProcessor(libs.compiler)

    // Testes
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.androidx.core.testing)

    //firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.com.google.firebase.firebase.auth.ktx)

    // Koin
    implementation("io.insert-koin:koin-android:2.2.3")
    implementation("io.insert-koin:koin-androidx-viewmodel:2.2.3")

    // Room
    implementation(libs.androidx.room.runtime.v252)
    implementation(libs.androidx.room.ktx.v252)

    // Retrofit
    implementation(libs.retrofit.v290)
    implementation(libs.converter.gson.v290)

    //firebase
    implementation(platform(libs.firebase.bom))
    implementation(platform(libs.google.firebase.auth.ktx))

    // Coroutines
    implementation(libs.kotlinx.coroutines.android)

    // OkHttp
    implementation(libs.okhttp.v4110)
    implementation(libs.logging.interceptor)

    // Gson
    implementation(libs.gson)

    // AndroidX Test
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)
}

