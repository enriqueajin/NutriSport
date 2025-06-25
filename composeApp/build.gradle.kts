import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.serialization)
//    alias(libs.plugins.google.services)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        
        androidMain.dependencies {
//            implementation(compose.preview)
//            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.compose.navigation)
            implementation(libs.splash.screen)
            implementation(libs.koin.android)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.ktor.android.client)
            implementation(libs.coil3)
            implementation(libs.coil3.compose)
            implementation(libs.coil3.compose.core)
            implementation(libs.coil3.network.ktor)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
//            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.kotlinx.serialization)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.serialization)
            implementation(libs.koin.core)
            implementation(libs.messagebar.kmp)
            implementation(libs.browser.kmp)
            implementation(libs.multiplatform.settings)
            implementation(libs.multiplatform.settings.no.arg)
            implementation(libs.multiplatform.settings.make.observable)
            implementation(libs.auth.kmp)
            implementation(libs.auth.firebase.kmp)
            implementation(libs.kmp.notifier)
            implementation(libs.firebase.app)
            implementation(libs.firebase.firestore)
            implementation(libs.firebase.storage)
            implementation(libs.firebase.common)
        }
        commonTest.dependencies {
//            implementation(libs.kotlin.test)
            implementation(libs.ktor.darwin.client)
        }
    }
}

android {
    namespace = "com.enriquedev.nutrisport"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.enriquedev.nutrisport"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

