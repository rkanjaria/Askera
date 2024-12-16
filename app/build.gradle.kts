import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.devtools.ksp)
}

android {
    namespace = "com.ai.askera"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ai.askera"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }

    buildTypes {

        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())

        val stringType = "String"
        val booleanType = "Boolean"
        val baseUrl = "https://staging.getpi.in/"

        debug {
            isMinifyEnabled = false
            isDebuggable = true
            isShrinkResources = false

            buildConfigField(booleanType, "DEBUG", isDebuggable.toString())
            buildConfigField(stringType, "BASE_URL", "\"$baseUrl\"")

            buildConfigField(
                type = stringType,
                name = "API_KEY",
                value = "\"${properties.getProperty("API_KEY")}\""
            )

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        release {
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true

            buildConfigField(booleanType, "DEBUG", isDebuggable.toString())
            buildConfigField(stringType, "BASE_URL", "\"$baseUrl\"")

            buildConfigField(
                type = stringType,
                name = "API_KEY",
                value = "\"${properties.getProperty("API_KEY")}\""
            )


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
        compose = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.androidx.navigation.runtime.ktx)
    debugImplementation(libs.bundles.compose.debug)

    coreLibraryDesugaring(libs.desugar.jdk.libs)

    // Koin
    implementation(libs.bundles.koin)

    // Ktor
    implementation(libs.bundles.ktor)

    // Navigation
    implementation(libs.androidx.navigation.compose)

    // Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    //Splash Screen
    implementation(libs.androidx.core.splashscreen)

    // Generative Ai
    implementation(libs.generativeai)

    // Markdown
    implementation(libs.compose.markdown)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
}